package com.jianyi.utils;

import lombok.Data;

import java.io.Serializable;
@Data
public class AjaxResult implements Serializable {

    private  int code;
    private  String msg;
    private  Object data;


    public static AjaxResult success(int code,String msg,Object data){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(code);
        ajaxResult.setData(data);
        ajaxResult.setMsg(msg);
        return ajaxResult;
    }
    public static AjaxResult success(Object data){
    return success(200,"操作成功",data);
    }
    public static AjaxResult success(String msg,Object data){
        return success(200,msg,data);
    }
    public static AjaxResult success(String msg){
        return success(200,msg,null);
    }

    public static AjaxResult erro(String msg,Object data){
        return success(500,msg,data);
    }
    public static AjaxResult erro(String msg){
        return success(500,msg,null);
    }


}
