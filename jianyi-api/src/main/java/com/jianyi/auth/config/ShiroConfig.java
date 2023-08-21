package com.jianyi.auth.config;



import com.jianyi.auth.filter.JWTFilter;
import com.jianyi.auth.realm.MyRealm;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ShiroConfig {

    private  static  final  String ANON = "anon";

    @Bean("securityManager")
    public DefaultWebSecurityManager getManager(MyRealm myRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        // 使用自己的realm
        manager.setRealm(myRealm);

        /*
         * 关闭shiro自带的session，详情见文档
         * http://shiro.apache.org/session-management.html#SessionManagement-StatelessApplications%28Sessionless%29
         */
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        manager.setSubjectDAO(subjectDAO);
        ThreadContext.bind(manager);
        return manager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean factory(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        // 添加自己的过滤器并且取名为jwt
        Map<String, Filter> filterMap = new LinkedHashMap<>();
//        filterMap.put("f2cPerms", new F2CPermissionsFilter());
        filterMap.put("jwt", new JWTFilter());
//        filterMap.put("logout", new F2CLogoutFilter());
//        filterMap.put("link", new F2CLinkFilter());
//        filterMap.put("doc", new F2CDocFilter());
        factoryBean.setSecurityManager(securityManager);
        factoryBean.setLoginUrl("/#/");
//        factoryBean.setUnauthorizedUrl("/noAuthorized");

        // 权限控制map
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 配置过滤:不会被拦截的链接 -> 放行 start
        // ----------------------------------------------------------
        // 放行Swagger2页面，需要放行这些
        filterChainDefinitionMap.put("/blog/hotsix",ANON);
        filterChainDefinitionMap.put("/blog/list/**",ANON);
        filterChainDefinitionMap.put("/blog/getOne",ANON);
        filterChainDefinitionMap.put("/bili/download",ANON);
        filterChainDefinitionMap.put("/blog/getOneNum",ANON);
        filterChainDefinitionMap.put("/es/blog/**",ANON);

        //分组栏
        filterChainDefinitionMap.put("/blog/category/firstCate",ANON);
        filterChainDefinitionMap.put("/blog/category/childCate",ANON);
        //热度作者
        filterChainDefinitionMap.put("/user/gethotusers",ANON);

        //评论树放行
        filterChainDefinitionMap.put("/blog/comment/tree",ANON);
        //评论获取用户基础信息接口
        filterChainDefinitionMap.put("/user/getUser",ANON);

        filterChainDefinitionMap.put("/auth/login", ANON);
        filterChainDefinitionMap.put("/auth/getCode", ANON);
        filterChainDefinitionMap.put("/auth/register", ANON);


        filterChainDefinitionMap.put("/static/**", ANON);
        filterChainDefinitionMap.put("/css/**", ANON);
        filterChainDefinitionMap.put("/js/**", ANON);
        filterChainDefinitionMap.put("/undefined/**",ANON);
        filterChainDefinitionMap.put("/img/**", ANON);
        filterChainDefinitionMap.put("/fonts/**", ANON);
        filterChainDefinitionMap.put("/favicon.ico", ANON);
        filterChainDefinitionMap.put("/cover/**", ANON);
        filterChainDefinitionMap.put("/", ANON);
        filterChainDefinitionMap.put("/login", ANON);
        filterChainDefinitionMap.put("/**", "authc");

        filterChainDefinitionMap.put("/**", "jwt");

//        filterChainDefinitionMap.put("/system/auth/captchaImage",ANON)


        factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        factoryBean.setFilters(filterMap);
        return factoryBean;
    }

    /**
     * 下面的代码是添加注解支持
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}

