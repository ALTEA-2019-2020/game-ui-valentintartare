package com.miage.altea.game_ui.controller;

import com.miage.altea.game_ui.pokemonTypes.services.PokemonTypeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
@Data
public class PokemonTypeController {

    @Autowired
    PokemonTypeService pokemonTypeService;

    @GetMapping("/pokedex")
    public ModelAndView pokedex() {
        ModelAndView modelAndView = new ModelAndView("pokedex");
        modelAndView.addObject("pokemonTypes", this.pokemonTypeService.listPokemonsTypes());
        return modelAndView;
    }

}
