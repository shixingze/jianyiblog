package com.jianyi.service.bilifile;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.jianyi.jianyiblog.common.AjaxResult;
import com.jianyi.utils.HttpClientUtils;
import com.jianyi.utils.ServletUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class BiliService {


    public AjaxResult BILIFileSave(String path, HttpServletResponse response) {
        //获取bvid
        //https://www.bilibili.com/video/BV1n4411s7FV/?spm_id_from=333.337.search-card.all.click
        if (StringUtils.isEmpty(path)) {
            return AjaxResult.error("为输入视频地址");
        }
        try {
            String[] strings = path.split("/");
            String bvid = strings[4];
            String getCidPath = "https://api.bilibili.com/x/web-interface/view?bvid="+bvid;
            if (StringUtils.isNotEmpty(bvid)) {
             String result =   HttpClientUtils.doGet(getCidPath);
                Integer cid = (Integer) JSONPath.read(result,"$.data.cid");
                String title = (String) JSONPath.read(result,"$.data.title");
                if (ObjectUtils.isEmpty(cid)){
                    return  AjaxResult.error("获取cid失败");
                }
            //视频地址获取
              String getmovePath =  "https://api.bilibili.com/x/player/playurl?otype=json&fnver=0&fnval=2&player=1&qn=64&bvid="+bvid+"&cid="+cid;
                String MoveResult =   HttpClientUtils.doGet(getmovePath);
                //获取视频地址
                String url = (String) JSONPath.read(MoveResult,"$.data.durl[0].url");
                if (StringUtils.isNotEmpty(url)){
                    download(url,response,title);
                }else {
                    return  AjaxResult.error("视频原始地址未生成");
                }
            }else {
                return AjaxResult.error("获取bvid失败");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return AjaxResult.success();
    }
    public void  download(String path, HttpServletResponse response,String title){
        HttpURLConnection urlConnection = null;

        try {
            long begin = System.currentTimeMillis();
            URL url = new URL(path);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Referer", "https://www.bilibili.com"); // 设置协议
            urlConnection.setRequestProperty("Sec-Fetch-Mode", "no-cors");
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36");
            urlConnection.setConnectTimeout(10 * 1000);
            System.out.println("共:" + (urlConnection.getContentLength() / 1024) + "Kb");
            BufferedInputStream bis = new BufferedInputStream(urlConnection.getInputStream());
            System.out.println("开始下载...");
            //写入到文件（注意文件保存路径的后面一定要加上文件的名称）

            //生命下载文件头
            ServletUtils.setFileDownLoad(response,title);
            OutputStream stream = response.getOutputStream();
            byte[] buf = new byte[2048];
            int length;
            //保存文件
            while((length =bis.read(buf))!= -1)
            {
                stream.write(buf, 0, length);
            }
            long end = System.currentTimeMillis();
            System.out.println("耗时：" + (end - begin) / 1000 + "秒");
            System.out.println("下载完成！");
            bis.close();
        } catch (Exception e) {
            System.out.println("异常中止: " + e);
        }
    }



}
