package com.pokedex.pokedex.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class PokedexDto {

    private String next;
    private String previous;
    private List<PokemonDTO> pokemons;

    // Constructor privado para evitar la creación directa de instancias
    private PokedexDto() {
    }

    // Método builder estático para comenzar la construcción
    public static PokedexBuilder builder() {
        return new PokedexBuilder();
    }

    // Clase estática interna que actúa como el constructor del objeto PokedexDto
    public static class PokedexBuilder {

        private PokedexDto pokedexDto = new PokedexDto();

        private PokedexBuilder() {
        }

        public PokedexBuilder next(String next) {
            pokedexDto.next = next;
            return this;
        }

        public PokedexBuilder previous(String previous) {
            pokedexDto.previous = previous;
            return this;
        }

        public PokedexBuilder pokemons(List<PokemonDTO> pokemons) {
            pokedexDto.pokemons = pokemons;
            return this;
        }

        public PokedexDto build() {
            // Puedes realizar validaciones adicionales antes de construir el objeto
            return pokedexDto;
        }
    }
}