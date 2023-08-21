package com.jianyi.jianyiblog.controller;

import com.jianyi.jianyiblog.common.AjaxResult;
import com.jianyi.jianyiblog.entity.Blog;
import com.jianyi.jianyiblog.service.BlogService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogService blogService;

    @GetMapping("/hotsix")
    public AjaxResult getHotSixLog(){
     return blogService.getHotSix();
    }
    @PostMapping("/list/{gopage}/{pageSize}")
    public AjaxResult list(@RequestBody Blog blog,@PathVariable("gopage") int gopage,@PathVariable("pageSize") int pageSize){
        return  blogService.list(blog,gopage,pageSize);
    }

    @PostMapping("/getOne")
    public AjaxResult getOne(@RequestBody Blog blog) throws ParseException {
        return  blogService.getOne(blog);
    }

    /**
     * 获取本篇章的点赞评论等
     * @param blog
     * @return
     * @throws ParseException
     */
    @PostMapping("/getOneNum")
    public AjaxResult getOneNum(@RequestBody Blog blog) throws ParseException {
        return  blogService.getBlogStatisticalData(blog);
    }
    /**
     * 修改新增接口
     * @param blog 参数对象
     * @return
     */
    @PostMapping("/save")
    public AjaxResult add(@RequestBody Blog blog){
        return  blogService.save(blog);
    }

    @GetMapping("/ceshi")
    public AjaxResult ceshi(){
        return  AjaxResult.success("成功");
    }
    @GetMapping("/portal")
    public AjaxResult portal(){
        return  AjaxResult.success("成功");
    }

    /**
     * 封面上传
     * @return
     */
    @PostMapping("/cover/upload")
    public AjaxResult upload(@RequestParam("file") MultipartFile file) throws IOException {
        return blogService.coverUpload(file);
    }

    /**
     * 本月热度文章
     * @return
     */
    @GetMapping("/mouthHot")
    public AjaxResult mouthHot(){
        return blogService.mouthHot();
    }

    /**
     * 分享二维码返回
     */
    @GetMapping("/share")
    public AjaxResult share(Blog blog, HttpServletRequest request){

        System.out.println(request.getContextPath());
        System.out.println(request.getRequestURI());
        return AjaxResult.success();


    }

}
