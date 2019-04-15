package com.yw.myexcel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MyExcelApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyExcelApplication.class, args);
    }

}
