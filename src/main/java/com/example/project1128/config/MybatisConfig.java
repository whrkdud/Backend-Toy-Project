package com.example.project1128.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.example.project1128.mapper")
public class MybatisConfig {
    
}
