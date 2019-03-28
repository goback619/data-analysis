package com.witown;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.witown.location.mapper")
public class DataAnalysisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataAnalysisApplication.class, args);
	}

}
