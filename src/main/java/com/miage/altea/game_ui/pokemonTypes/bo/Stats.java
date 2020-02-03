package com.miage.altea.game_ui.pokemonTypes.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Stats {

    private Integer speed;
    private Integer defense;
    private Integer attack;
    private Integer hp;

}
