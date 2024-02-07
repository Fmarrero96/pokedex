package com.pokedex.pokedex.Controller;

import com.pokedex.pokedex.Service.PokedexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/pokedex")
public class PokedexController {

    @Autowired
    private PokedexService pokedexService;

    @GetMapping("/all")
    public String getPokedexPaginator(){

        return pokedexService.getPokemonPaginator();
    }

}
