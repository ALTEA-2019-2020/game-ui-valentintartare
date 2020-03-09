package com.miage.altea.game_ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GameUI {

    public static void main(String... args){
        SpringApplication.run(GameUI.class, args);
    }

}
