package com.jianyi.jianyiblog.common.utils;

import java.io.*;

/**
 * 文件上传工具类
 */
public class FileUploadUtils {
    /**
     *
     * @param fileName 文 件名称
     * @param path 文件地址
     * @param inputStream 文件流
     */
    public   static boolean upload(String fileName,String path,InputStream inputStream){
        FileOutputStream outputStream = null;
        if (createPath(path)){
        try {
             outputStream = new FileOutputStream(path +fileName);
            int len = -1;
            byte[] bytes = new byte[1024];
            while ((len = inputStream.read(bytes)) != -1){
             outputStream.write(bytes,0,len);
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
        return false;
    }

    public static boolean createPath(String uploadPath){
        //构建文件对象
        File file = new File(uploadPath);
        //文件目录不存在则递归创建目录
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (!mkdirs) {
                System.out.println("创建文件异常");
                return false;
            }
        }
        return true;
    }
}
