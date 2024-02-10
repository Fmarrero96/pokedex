package com.pokedex.pokedex.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.pokedex.pokedex.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class PokedexService {
    @Autowired
    PokemonService pokemonService;

    public ResponsePagePokedex getPokemonPaginator(String offset,String limit){
        RestTemplate plantilla = new RestTemplate();
        ResponsePagePokedex response= plantilla.getForEntity("https://pokeapi.co/api/v2/pokemon/?offset=" +offset + "&limit=" + limit, ResponsePagePokedex.class).getBody();
        return(response);
    }

    public PokedexDto getPokedexDto(String offset,String limit) throws JsonProcessingException {
        ResponsePagePokedex responsePagePokedex = getPokemonPaginator(offset,limit);

        PokedexDto pokedex = PokedexDto.builder()
                .next(responsePagePokedex.getNext())
                .previous(responsePagePokedex.getPrevious())
                .pokemons(pokemonService.getPokemonsDtoForResponsePokedex(responsePagePokedex))
                .build();

        return pokedex;
    }
}
