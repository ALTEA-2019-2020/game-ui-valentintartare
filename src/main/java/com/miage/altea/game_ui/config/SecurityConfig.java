package com.miage.altea.game_ui.config;

import com.miage.altea.game_ui.pokemonTypes.services.TrainersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    TrainersService trainersService;

    @Autowired
    public void setTrainersService(TrainersService trainersService) {
        this.trainersService = trainersService;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
       return username -> Optional.ofNullable(trainersService.getTrainers(username))
               .map(trainer ->
                       User.withUsername(trainer.getName()).password(trainer.getPassword()).roles("USER").build())
               .orElseThrow(() -> new BadCredentialsException("No such user"));
    }
}
