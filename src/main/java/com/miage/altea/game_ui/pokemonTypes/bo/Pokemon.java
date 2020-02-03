package com.miage.altea.game_ui.pokemonTypes.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pokemon {

    private int pokemonTypeId;

    private int level;
}
