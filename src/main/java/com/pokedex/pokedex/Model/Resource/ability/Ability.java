package com.pokedex.pokedex.Model.Resource.ability;

import java.util.List;

import com.pokedex.pokedex.Model.Resource.Name;
import com.pokedex.pokedex.Model.Resource.NamedApiResource;
import com.pokedex.pokedex.Model.Resource.PokeApiResource;
import com.pokedex.pokedex.Model.Resource.VerboseEffect;
import com.pokedex.pokedex.Model.Resource.generation.Generation;
import com.pokedex.pokedex.Model.Util.Localizable;

public class Ability implements PokeApiResource, Localizable {

	private Integer id;
	private String name;
	private Boolean isMainSeries;
	private NamedApiResource<Generation> generation;
	private List<Name> names;
	private List<VerboseEffect> effectEntries;
	private List<AbilityEffectChange> effectChanges;
	private List<AbilityFlavorText> flavorTextEntries;
	private List<AbilityPokemon> pokemon;
	
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
	public Boolean getIsMainSeries() {
		return isMainSeries;
	}
	public void setIsMainSeries(Boolean isMainSeries) {
		this.isMainSeries = isMainSeries;
	}
	public List<Name> getNames() {
		return names;
	}
	public void setNames(List<Name> names) {
		this.names = names;
	}
	public NamedApiResource<Generation> getGeneration() {
		return generation;
	}
	public void setGeneration(NamedApiResource<Generation> generation) {
		this.generation = generation;
	}
	public List<VerboseEffect> getEffectEntries() {
		return effectEntries;
	}
	public void setEffectEntries(List<VerboseEffect> effectEntries) {
		this.effectEntries = effectEntries;
	}
	public List<AbilityEffectChange> getEffectChanges() {
		return effectChanges;
	}
	public void setEffectChanges(List<AbilityEffectChange> effectChanges) {
		this.effectChanges = effectChanges;
	}
	public List<AbilityFlavorText> getFlavorTextEntries() {
		return flavorTextEntries;
	}
	public void setFlavorTextEntries(List<AbilityFlavorText> flavorTextEntries) {
		this.flavorTextEntries = flavorTextEntries;
	}
	public List<AbilityPokemon> getPokemon() {
		return pokemon;
	}
	public void setPokemon(List<AbilityPokemon> pokemon) {
		this.pokemon = pokemon;
	}
	
}
