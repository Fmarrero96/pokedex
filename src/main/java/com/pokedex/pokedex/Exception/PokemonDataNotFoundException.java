package com.pokedex.pokedex.Exception;

public class PokemonDataNotFoundException extends RuntimeException {

    public PokemonDataNotFoundException(String message) {
        super(message);
    }
}