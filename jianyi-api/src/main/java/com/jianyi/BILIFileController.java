package com.jianyi;

import com.jianyi.entity.dto.BiliMoveDto;
import com.jianyi.jianyiblog.common.AjaxResult;
import com.jianyi.jianyiblog.common.utils.StringUtils;
import com.jianyi.service.bilifile.BiliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("/bili")
public class BILIFileController {

    @Autowired
    private BiliService biliService;
    @PostMapping("/download")
    public void down(@RequestBody BiliMoveDto biliMoveDto, HttpServletResponse response) {
        if (StringUtils.isNotEmpty(biliMoveDto.getURL())){
            biliService.BILIFileSave(biliMoveDto.getURL(),response);
        }else {
            AjaxResult.error("未输入地址");
        }
    }
}
