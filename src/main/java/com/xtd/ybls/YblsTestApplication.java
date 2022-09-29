package com.xtd.ybls;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @author 冯瑞宁
 */
@EnableScheduling
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class YblsTestApplication{
    public static void main(String[] args) {
        SpringApplication.run(YblsTestApplication.class, args);
        System.out.println("=============================================================系统正在运行=============================================================");
    }
}
