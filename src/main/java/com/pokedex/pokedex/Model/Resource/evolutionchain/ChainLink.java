package com.pokedex.pokedex.Model.Resource.evolutionchain;

import java.util.List;

import com.pokedex.pokedex.Model.Resource.NamedApiResource;
import com.pokedex.pokedex.Model.Resource.pokemonspecies.PokemonSpecies;

public class ChainLink {

	private Boolean isBaby;
	private NamedApiResource<PokemonSpecies> species;
	private List<EvolutionDetail> evolutionDetails;
	private List<ChainLink> evolvesTo;
	
	public Boolean getIsBaby() {
		return isBaby;
	}
	public void setIsBaby(Boolean isBaby) {
		this.isBaby = isBaby;
	}
	public NamedApiResource<PokemonSpecies> getSpecies() {
		return species;
	}
	public void setSpecies(NamedApiResource<PokemonSpecies> species) {
		this.species = species;
	}
	public List<EvolutionDetail> getEvolutionDetails() {
		return evolutionDetails;
	}
	public void setEvolutionDetails(List<EvolutionDetail> evolutionDetails) {
		this.evolutionDetails = evolutionDetails;
	}
	public List<ChainLink> getEvolvesTo() {
		return evolvesTo;
	}
	public void setEvolvesTo(List<ChainLink> evolvesTo) {
		this.evolvesTo = evolvesTo;
	}
	
}
