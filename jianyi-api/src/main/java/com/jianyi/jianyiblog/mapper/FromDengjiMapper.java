package com.jianyi.jianyiblog.mapper;


import com.jianyi.jianyiblog.entity.FromDengji;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author lihai
 * Create Date: 2021-10-04
 */
@Mapper
public interface FromDengjiMapper  {

    public  void add(FromDengji dengji);

    public List<FromDengji> list(FromDengji dengji);

}
