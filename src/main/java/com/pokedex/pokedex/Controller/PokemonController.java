package com.pokedex.pokedex.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pokedex.pokedex.Model.PokemonDTO;
import com.pokedex.pokedex.Model.PokemonDetailDto;
import com.pokedex.pokedex.Service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @PostMapping("/uno")
    public PokemonDetailDto getPokemonDetailDTO(@RequestBody PokemonDTO pokemonDto) throws JsonProcessingException {
        return pokemonService.getPokemonDtoDetail(pokemonDto);
    }
}
