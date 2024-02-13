package com.pokedex.pokedex.Component;
import com.pokedex.pokedex.Model.Resource.pokemon.Pokemon;
import com.pokedex.pokedex.Model.ResponsePagePokedex;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.Option;

@Component
public class PokemonRestClient {
    private final RestTemplate restTemplate;

    public PokemonRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String fetchData(String url) {
        return restTemplate.getForObject(url, String.class);
    }

    public Pokemon fetchDataPokemon(String url) {
        return restTemplate.getForEntity(url,Pokemon.class).getBody();
    }

    public ResponsePagePokedex fetchDataResponsePagePokedex(String url){
        return restTemplate.getForEntity(url,ResponsePagePokedex.class).getBody();
    }

}

