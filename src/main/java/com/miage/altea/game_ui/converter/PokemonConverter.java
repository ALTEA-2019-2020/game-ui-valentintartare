package com.miage.altea.game_ui.converter;

import com.miage.altea.game_ui.pokemonTypes.bo.Pokemon;
import com.miage.altea.game_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.game_ui.pokemonTypes.bo.PokemonTypeWithLevel;
import com.miage.altea.game_ui.pokemonTypes.services.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PokemonConverter {

    @Autowired
    PokemonTypeService pokemonTypeService;

    public PokemonTypeWithLevel pokemonToPokemonWithLevel(Pokemon pokemon) {
        PokemonType pokemonType = pokemonTypeService.pokemon(pokemon.getPokemonTypeId());
        return PokemonTypeWithLevel.builder()
                .id(pokemonType.getId())
                .level(pokemon.getLevel())
                .baseExperience(pokemonType.getBaseExperience())
                .height(pokemonType.getHeight())
                .sprites(pokemonType.getSprites())
                .stats(pokemonType.getStats())
                .name(pokemonType.getName())
                .types(pokemonType.getTypes())
                .weight(pokemonType.getWeight())
                .build();
    }
}
