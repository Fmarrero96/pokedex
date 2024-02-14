package com.pokedex.pokedex.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.pokedex.pokedex.Component.PokemonRestClient;
import com.pokedex.pokedex.Exception.PokemonDataNotFoundException;
import com.pokedex.pokedex.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PokedexService {
    @Autowired
    PokemonService pokemonService;

    @Autowired
    private final PokemonRestClient pokemonRestClient;

    private static final String POKEMON_PAGE_API_URL = "https://pokeapi.co/api/v2/pokemon/";

    @Autowired
    public PokedexService(PokemonRestClient pokemonRestClient) {
        this.pokemonRestClient = pokemonRestClient;
    }

    public ResponsePagePokedex getPaginatorPokemon(String offset,String limit){
        try {
            return pokemonRestClient.fetchDataResponsePagePokedex(POKEMON_PAGE_API_URL + "?offset=" + offset + "&limit=" + limit);
        } catch (PokemonDataNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public PokedexDto getPokedexDto(String offset,String limit) throws JsonProcessingException {
        ResponsePagePokedex responsePagePokedex = getPaginatorPokemon(offset,limit);

        PokedexDto pokedex = PokedexDto.builder()
                .next(responsePagePokedex.getNext())
                .previous(responsePagePokedex.getPrevious())
                .pokemons(pokemonService.getPokemonsDtoForResponsePokedex(responsePagePokedex))
                .build();

        return pokedex;
    }

}
