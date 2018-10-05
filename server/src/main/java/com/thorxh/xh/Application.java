package com.thorxh.xh;

import com.thorxh.xh.common.CustomMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@Log4j2
@MapperScan(basePackages  = {"com.thorxh.xh.photoalbum.mapper"}, markerInterface  = CustomMapper.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("server start");
    }

}
