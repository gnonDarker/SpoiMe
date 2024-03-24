package com.example.spoilme;

import com.example.spoilme.netty.IMServer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.example.spoilme.mapper")
public class SpoilmeApplication implements CommandLineRunner {

    @Autowired
    IMServer imServer;

    public static void main(String[] args) {
        SpringApplication.run(SpoilmeApplication.class, args);
    }

    @Override
    public void run(String... args) {
        this.imServer.start();
    }

}
