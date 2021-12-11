package com.aiden.kpcon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.aiden.kpcon.mapper")
@SpringBootApplication
@EnableScheduling
public class KpconApplication{

	public static void main(String[] args) {
		SpringApplication.run(KpconApplication.class, args);
	}

}
