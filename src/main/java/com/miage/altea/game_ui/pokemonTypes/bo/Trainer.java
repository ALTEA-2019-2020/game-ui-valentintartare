package com.miage.altea.game_ui.pokemonTypes.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trainer {

    private String name;

    private List<Pokemon> team;

    public Trainer(String name) {
        this.name = name;
    }
}
