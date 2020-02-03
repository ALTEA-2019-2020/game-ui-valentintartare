package com.miage.altea.game_ui.pokemonTypes.services;

import com.miage.altea.game_ui.pokemonTypes.bo.PokemonType;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    private RestTemplate restTemplate;

    private String pokemonServiceUrl;

    public List<PokemonType> listPokemonsTypes() {
        return Arrays.asList(Objects.requireNonNull
                (restTemplate.getForObject(pokemonServiceUrl + "/pokemon-types/", PokemonType[].class)));
    }

    public PokemonType pokemon(long id) {
        return Objects.requireNonNull
                (restTemplate.getForObject(pokemonServiceUrl + "/pokemon-types/"+id, PokemonType.class));
    }

    @Autowired
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${pokemonType.service.url}")
    void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl;
    }
}
