package com.pokedex.pokedex.Model;

import java.util.List;

public class Pokemon {
    private String name;
    private String imageUrl;
    private String type;

    // Constructor privado para evitar instancias directas
    private Pokemon() {
    }

    // Método builder estático para comenzar la construcción
    public static PokemonBuilder builder() {
        return new PokemonBuilder();
    }

    // Clase estática interna que actúa como el constructor del objeto Pokemon
    public static class PokemonBuilder {
        private Pokemon pokemon = new Pokemon();

        private PokemonBuilder() {
        }

        public PokemonBuilder name(String name) {
            pokemon.name = name;
            return this;
        }

        public PokemonBuilder imageUrl(String imageUrl) {
            pokemon.imageUrl = imageUrl;
            return this;
        }

        public PokemonBuilder type(String type) {
            pokemon.type = type;
            return this;
        }

        public PokemonBuilder weight(int weight) {
            pokemon.weight = weight;
            return this;
        }

        public PokemonBuilder abilities(List<String> abilities) {
            pokemon.abilities = abilities;
            return this;
        }

        public Pokemon build() {
            // Puedes realizar validaciones adicionales antes de construir el objeto
            return pokemon;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    private int weight;
    private List<String> abilities;
}
