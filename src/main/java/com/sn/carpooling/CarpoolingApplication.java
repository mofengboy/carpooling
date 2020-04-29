package com.sn.carpooling;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sn.carpooling.dao")
public class CarpoolingApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarpoolingApplication.class, args);
    }
}
