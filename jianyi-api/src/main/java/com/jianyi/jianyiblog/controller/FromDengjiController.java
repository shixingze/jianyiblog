package com.jianyi.jianyiblog.controller;


import com.jianyi.jianyiblog.common.AjaxResult;
import com.jianyi.jianyiblog.entity.FromDengji;
import com.jianyi.jianyiblog.service.FromDengjiService;
import com.jianyi.utils.QRCodeUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/from")
public class FromDengjiController {
    @Resource
    private FromDengjiService fromDengjiService;


    @PostMapping("/add")
    public AjaxResult add(@RequestBody FromDengji fromDengji) {
        fromDengjiService.add(fromDengji);
        return AjaxResult.success();
    }
    @GetMapping("/image")
    public void image(String url, HttpServletResponse response) throws Exception {
        QRCodeUtil.encode(url,response);
    }

    @PostMapping("/list")
    public AjaxResult image(@RequestBody FromDengji dengji) throws Exception {
     return AjaxResult.success(fromDengjiService.list(dengji));
    }
}
