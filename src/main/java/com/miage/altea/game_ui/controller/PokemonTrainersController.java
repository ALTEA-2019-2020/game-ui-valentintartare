package com.miage.altea.game_ui.controller;

import com.miage.altea.game_ui.converter.PokemonConverter;
import com.miage.altea.game_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.game_ui.pokemonTypes.bo.Trainer;
import com.miage.altea.game_ui.pokemonTypes.services.PokemonTypeService;
import com.miage.altea.game_ui.pokemonTypes.services.PokemonTypeServiceImpl;
import com.miage.altea.game_ui.pokemonTypes.services.TrainerServiceImpl;
import com.miage.altea.game_ui.pokemonTypes.services.TrainersService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
@RequestMapping
@Data
public class PokemonTrainersController {

    @Autowired
    TrainersService trainerServiceImpl;

    @Autowired
    PokemonConverter pokemonConverter;

    @Autowired
    SecurityControllerAdvice securityControllerAdvice;

    @GetMapping("/trainers")
    public ModelAndView trainers() {
        ModelAndView modelAndView = new ModelAndView("trainers");
        modelAndView.addObject("trainerList", this.trainerServiceImpl.listTrainers());
        return modelAndView;
    }

    @GetMapping("/trainers/{name}")
    public ModelAndView trainers(@PathVariable String name) {
        ModelAndView modelAndView = new ModelAndView("trainerTeam");
        Trainer trainer = trainerServiceImpl.getTrainers(name);
        modelAndView.addObject("trainer", trainer.getName());
        modelAndView.addObject("pokemonTypes",
                trainer.getTeam()
                        .stream()
                        .map(x -> pokemonConverter.pokemonToPokemonWithLevel(x))
                        .collect(Collectors.toList())
        );
        return modelAndView;
    }

    @GetMapping("/profile")
    public ModelAndView profile() {
        ModelAndView modelAndView = new ModelAndView("profile");
        Trainer trainer = trainerServiceImpl.getTrainers(((User)securityControllerAdvice.principal()).getUsername());
        modelAndView.addObject("trainer", trainer.getName());
        modelAndView.addObject("pokemonTypes",
                trainer.getTeam()
                        .stream()
                        .map(x -> pokemonConverter.pokemonToPokemonWithLevel(x))
                        .collect(Collectors.toList())
        );
        return modelAndView;
    }
}
