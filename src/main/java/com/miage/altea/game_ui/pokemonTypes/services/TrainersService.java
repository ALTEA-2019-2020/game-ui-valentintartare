package com.miage.altea.game_ui.pokemonTypes.services;

import com.miage.altea.game_ui.pokemonTypes.bo.Trainer;

import java.util.List;

public interface TrainersService {
        List<Trainer> listTrainers();
        Trainer getTrainers(String name);
}
