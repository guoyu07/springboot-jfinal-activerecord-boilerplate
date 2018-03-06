package com.gaols.studyspringboot.demo.db;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.sf.jfinal.qs.model._MappingKit;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DSConfig {
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    @Bean("master")
    public DataSource master() {
        return DruidDataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    @DependsOn("master")
    public SqlAwareDataSource sqlAwareDataSource() {
        return new SqlAwareDataSource(master(), true);
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(sqlAwareDataSource());
    }

    @Bean
    public ActiveRecordPlugin activeMaster() {
        ActiveRecordPlugin plugin = new ActiveRecordPlugin(sqlAwareDataSource());
        _MappingKit.mapping(plugin);
        plugin.start();
        return plugin;
    }

}
