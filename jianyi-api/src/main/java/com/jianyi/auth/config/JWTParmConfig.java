package com.jianyi.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class JWTParmConfig implements ApplicationRunner {
    @Autowired
    private Environment environment;
    public  static   String header;
    public static Long expire;

    @Override
    public void run(ApplicationArguments args) throws Exception {
      expire = Long.valueOf(environment.getProperty("jianyi.jwt.expire"));
      header = environment.getProperty("jianyi.jwt.header");
    }
}
