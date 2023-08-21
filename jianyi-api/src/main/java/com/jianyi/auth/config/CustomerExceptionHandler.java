package com.jianyi.auth.config;

import com.jianyi.jianyiblog.common.HttpStatus;
import com.jianyi.utils.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.message.AuthException;

/**
 * 异常处理
 */
@RestControllerAdvice
@Slf4j
public class CustomerExceptionHandler {

    @ExceptionHandler(AuthException.class)
    public String ErrorHandler(AuthorizationException e) {
        log.error("没有通过权限验证！", e);
        return "没有通过权限验证！";
    }
//    UnauthorizedException
    @ExceptionHandler(AuthenticationException.class)
    public AjaxResult authenticationException(AuthenticationException e) {
        log.error("身份验证异常", e);
        return AjaxResult.erro("身份验证异常");
    }
    @ExceptionHandler(UnauthorizedException.class)
    public AjaxResult unauthorizedException(AuthorizationException e) {
        log.error("很抱歉您当前暂无该功能权限", e);
        return AjaxResult.erro("你当前没有该功能权限！");
    }
    @ExceptionHandler(Exception.class)
    public AjaxResult Execption(Exception e) {
        log.error("未知异常！", e);
        return AjaxResult.success(HttpStatus.ERROR,e.getMessage(),null);
    }
}
