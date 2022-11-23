package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChessApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChessApplication.class, args);
    }
}

