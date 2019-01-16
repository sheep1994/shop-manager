package com.talent.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author guobing
 * @Title: MybatisConfig
 * @ProjectName shop-manager
 * @Description: mybatis配置文件
 * @date 2019/1/16下午5:53
 *
 * @EnableTransactionManagement: 启用事物管理
 */
@Configuration
@MapperScan(basePackages = {"com.talent.mapper"})
@EnableTransactionManagement
public class MybatisConfig {

    /**
     * 注入数据源
     */
    @Autowired
    private DataSource dataSource;

    /**
     * 配置注解完成事物管理
     * @return
     */
    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}
