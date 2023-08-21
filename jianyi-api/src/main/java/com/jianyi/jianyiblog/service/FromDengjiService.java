package com.jianyi.jianyiblog.service;


import com.jianyi.jianyiblog.entity.FromDengji;
import com.jianyi.jianyiblog.mapper.FromDengjiMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FromDengjiService {
    @Resource
    private FromDengjiMapper fromDengjiMapper;

    public  void add(FromDengji fromDengji){
        String getTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//输出 2021-06-03 00:34:24
     fromDengji.setCreateTime(getTime);
            fromDengjiMapper.add(fromDengji);
    }

    public List<FromDengji> list(FromDengji fromDengji){
      List<FromDengji> fromDengjiList =   fromDengjiMapper.list(fromDengji);
      return  fromDengjiList;
    }
}
