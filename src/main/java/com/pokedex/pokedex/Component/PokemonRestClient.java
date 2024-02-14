package com.pokedex.pokedex.Component;
import com.pokedex.pokedex.Exception.PokemonDataNotFoundException;
import com.pokedex.pokedex.Model.Resource.pokemon.Pokemon;
import com.pokedex.pokedex.Model.ResponsePagePokedex;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.Option;

@Component
public class PokemonRestClient {
    private final RestTemplate restTemplate;

    public PokemonRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String fetchData(String url) {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            } else {
                // Handle non-successful response (e.g., log error or throw an exception)
                throw new PokemonDataNotFoundException("Pokemon data not found for URL: " + url);
            }
        } catch (HttpClientErrorException.NotFound notFoundException) {
            // Handle 404 Not Found error (e.g., log error or throw an exception)
            throw new PokemonDataNotFoundException("Pokemon data not found for URL: " + url);
        }
    }

    public Pokemon fetchDataPokemon(String url) {
        try {
            ResponseEntity<Pokemon> response = restTemplate.getForEntity(url, Pokemon.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            } else {
                throw new PokemonDataNotFoundException("Pokemon data not found for URL: " + url);
            }
        } catch (HttpClientErrorException.NotFound notFoundException) {
            throw new PokemonDataNotFoundException("Pokemon data not found for URL: " + url);
        }
    }

    public ResponsePagePokedex fetchDataResponsePagePokedex(String url) {
        try {
            ResponseEntity<ResponsePagePokedex> response = restTemplate.getForEntity(url, ResponsePagePokedex.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            } else {
                throw new PokemonDataNotFoundException("Pokemon data not found for URL: " + url);
            }
        } catch (HttpClientErrorException.NotFound notFoundException) {
            throw new PokemonDataNotFoundException("Pokemon data not found for URL: " + url);
        }
    }

}

