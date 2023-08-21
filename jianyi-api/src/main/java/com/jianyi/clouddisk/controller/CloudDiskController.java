package com.jianyi.clouddisk.controller;

import com.jianyi.utils.AjaxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件存储模块
 * @author shixingze
 * @date 2022/12/13
 */

@RequestMapping("/cloud")
public class CloudDiskController {
    /**
     * 上传文件
     * @return
     */
    @PostMapping("/disk/upload")
    public AjaxResult upload(@RequestParam("file")MultipartFile file){
        return  AjaxResult.success(null);
    }
}
