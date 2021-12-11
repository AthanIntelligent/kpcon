package com.aiden.kpcon.shiro;

import com.aiden.kpcon.model.User;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //shiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getFilter(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroBean = new ShiroFilterFactoryBean();
        shiroBean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器
        /*
         anon,authc,user,perms,role
         */
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/user/login","anon");
        filterMap.put("/user/add","authc");

        shiroBean.setFilterChainDefinitionMap(filterMap);
        //设置登录链接
        shiroBean.setLoginUrl("/toLogin");
        return shiroBean;
    }
    //DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    //自定义realm
    @Bean
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }
}
