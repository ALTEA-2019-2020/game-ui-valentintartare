package com.miage.altea.game_ui.pokemonTypes.services;

import com.miage.altea.game_ui.pokemonTypes.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class TrainerServiceImpl implements TrainersService{
    private RestTemplate restTemplate;

    private String trainerApiUrl;

    @Autowired
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${trainerApi.service.url}")
    void setTrainerApiUrl(String pokemonServiceUrl) {
        this.trainerApiUrl = pokemonServiceUrl;
    }

    @Override
    public List<Trainer> listTrainers() {
        return Arrays.asList(Objects.requireNonNull
                (restTemplate.getForObject(trainerApiUrl + "/trainers/", Trainer[].class)));
    }

    @Override
    public Trainer getTrainers(String name) {
        return Objects.requireNonNull
                (restTemplate.getForObject(trainerApiUrl + "/trainers/"+name, Trainer.class));
    }
}
