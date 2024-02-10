package com.pokedex.pokedex.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pokedex.pokedex.Model.PokedexDto;
import com.pokedex.pokedex.Model.PokemonDetailDto;
import com.pokedex.pokedex.Service.PokedexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokedex")
public class PokedexController {

    @Autowired
    private PokedexService pokedexService;


    @GetMapping("/todos")
    public PokedexDto getPokedexDTO(@RequestParam(name="offset") String offset,
                                    @RequestParam(name="limit") String limit) throws JsonProcessingException {

        return pokedexService.getPokedexDto(offset,limit);
    }




}
