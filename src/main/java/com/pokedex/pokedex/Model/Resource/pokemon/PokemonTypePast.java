package com.pokedex.pokedex.Model.Resource.pokemon;

import com.pokedex.pokedex.Model.Resource.NamedApiResource;
import com.pokedex.pokedex.Model.Resource.generation.Generation;

import java.util.List;

public class PokemonTypePast {

    private NamedApiResource<Generation> generation;
    private List<PokemonType> types;
    
    public NamedApiResource<Generation> getGeneration() {
        return generation;
    }
    public void setGeneration(NamedApiResource<Generation> generation) {
        this.generation = generation;
    }
    public List<PokemonType> getTypes() {
        return types;
    }
    public void setTypes(List<PokemonType> types) {
        this.types = types;
    }
}
