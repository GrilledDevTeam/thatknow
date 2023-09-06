package com.grileddev.thatknow;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.grileddev.thatknow.util.AreaToGridXY;
import com.grileddev.thatknow.web.database.DBmanager;


@Configuration
public class AppConfig {
    
    @Bean
    public DBmanager dbManager() {
        return new DBmanager();
    }

    @Bean
    public AreaToGridXY areaToGridXY() {
        return new AreaToGridXY();
    }
}
