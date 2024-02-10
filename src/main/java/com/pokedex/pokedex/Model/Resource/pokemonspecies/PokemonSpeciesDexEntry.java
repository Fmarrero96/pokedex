package com.pokedex.pokedex.Model.Resource.pokemonspecies;

import com.pokedex.pokedex.Model.Resource.NamedApiResource;
import com.pokedex.pokedex.Model.Resource.pokedex.Pokedex;

public class PokemonSpeciesDexEntry {

	private Integer entryNumber;
	private NamedApiResource<Pokedex> pokedex;
	
	public Integer getEntryNumber() {
		return entryNumber;
	}
	public void setEntryNumber(Integer entryNumber) {
		this.entryNumber = entryNumber;
	}
	public NamedApiResource<Pokedex> getPokedex() {
		return pokedex;
	}
	public void setPokedex(NamedApiResource<Pokedex> pokedex) {
		this.pokedex = pokedex;
	}
	
}
