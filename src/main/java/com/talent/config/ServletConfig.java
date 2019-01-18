package com.talent.config;

import com.talent.filter.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author guobing
 * @Title: ServletConfig
 * @ProjectName shop-manager
 * @Description: 配置Servlet容器
 * @date 2019/1/17上午10:47
 */
@Configuration
public class ServletConfig {

    /**
     * 添加防止xss攻击过滤器
     */
    @Bean
    public FilterRegistrationBean xssFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new XssFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        return registrationBean;
    }
}
