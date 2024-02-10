package com.pokedex.pokedex.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class PokemonDTO {
    protected Integer id;
    protected String name;
    protected String imageUrl;

    protected Integer weight;
    protected List<String> type;

    protected List<String> abilities;

    // Constructor por defecto
    public PokemonDTO() {
        // Puedes inicializar campos aquí si es necesario
    }
}
