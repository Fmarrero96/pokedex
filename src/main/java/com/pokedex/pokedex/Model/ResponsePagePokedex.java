package com.pokedex.pokedex.Model;

import com.pokedex.pokedex.Model.ResponsePokedexPokemon;

import java.util.List;

public class ResponsePagePokedex {
    private int count;
    private String next;
    private String previous;
    private List<ResponsePokedexPokemon> results;

    // Constructor, getters y setters

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<ResponsePokedexPokemon> getResults() {
        return results;
    }

    public void setResults(List<ResponsePokedexPokemon> results) {
        this.results = results;
    }
}
