package com.pokedex.pokedex.Model.Resource.growthrate;

import java.util.List;

import com.pokedex.pokedex.Model.Resource.Description;
import com.pokedex.pokedex.Model.Resource.NamedApiResource;
import com.pokedex.pokedex.Model.Resource.PokeApiResource;
import com.pokedex.pokedex.Model.Resource.pokemonspecies.PokemonSpecies;

public class GrowthRate implements PokeApiResource {

	private Integer id;
	private String name;
	private String formula;
	private List<Description> descriptions;
	private List<GrowthRateExperienceLevel> levels;
	private List<NamedApiResource<PokemonSpecies>> pokemonSpecies;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
	public List<Description> getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(List<Description> descriptions) {
		this.descriptions = descriptions;
	}
	public List<GrowthRateExperienceLevel> getLevels() {
		return levels;
	}
	public void setLevels(List<GrowthRateExperienceLevel> levels) {
		this.levels = levels;
	}
	public List<NamedApiResource<PokemonSpecies>> getPokemonSpecies() {
		return pokemonSpecies;
	}
	public void setPokemonSpecies(List<NamedApiResource<PokemonSpecies>> pokemonSpecies) {
		this.pokemonSpecies = pokemonSpecies;
	}
	
}
