package com.zxl.mybatis_demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.zxl.mybatis_demo.mapper")
public class MybatisConfig {
}
