package com.talent.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guobing
 * @Title: DruitConfig
 * @ProjectName shop-manager
 * @Description: Druid数据源配置
 * @date 2019/1/16下午4:33
 */
@Configuration
public class DruitConfig {

    /**
     * 配置Druid数据源
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }


    /**
     * 配置进入Druid管理后台的Servlet
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // 配置进入后台的登录名和密码
        Map<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123456");
        registrationBean.setInitParameters(initParams);
        return registrationBean;
    }

    /**
     * 配置数据监控的过滤器
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new WebStatFilter());
        // 对所有请求进行拦截
        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        Map<String, String> initParams = new HashMap<>();
        // 对这些请求不进行拦截
        initParams.put("exclusions", "*.css,*.js,/druid/*");
        registrationBean.setInitParameters(initParams);
        return registrationBean;
    }

}
