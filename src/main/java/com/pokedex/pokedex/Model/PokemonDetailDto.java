package com.pokedex.pokedex.Model;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
public class PokemonDetailDto extends PokemonDTO {

    private String description;
    private List<String> moves;
}
