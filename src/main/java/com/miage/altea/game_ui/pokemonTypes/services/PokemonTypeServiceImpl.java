package com.miage.altea.game_ui.pokemonTypes.services;

import com.miage.altea.game_ui.pokemonTypes.bo.PokemonType;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    private RestTemplate restTemplate;

    private String pokemonServiceUrl;


    public List<PokemonType> listPokemonsTypes() {
        return Arrays.asList(Objects.requireNonNull(Objects.requireNonNull(
                restTemplate.exchange(pokemonServiceUrl + "/pokemon-types/", HttpMethod.GET, this.getHttpEntity(), PokemonType[].class)).getBody())
        );
    }

    public PokemonType pokemon(long id) {
        return Objects.requireNonNull
                (restTemplate.exchange(pokemonServiceUrl + "/pokemon-types/"+id, HttpMethod.GET, this.getHttpEntity(), PokemonType.class)).getBody();
    }

    private HttpEntity getHttpEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAcceptLanguageAsLocales(Collections.singletonList(LocaleContextHolder.getLocale()));
        return new HttpEntity<>("body", headers);
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
