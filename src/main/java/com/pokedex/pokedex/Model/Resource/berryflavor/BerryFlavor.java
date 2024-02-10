package com.pokedex.pokedex.Model.Resource.berryflavor;

import java.util.List;

import com.pokedex.pokedex.Model.Resource.Name;
import com.pokedex.pokedex.Model.Resource.NamedApiResource;
import com.pokedex.pokedex.Model.Resource.PokeApiResource;
import com.pokedex.pokedex.Model.Resource.contesttype.ContestType;
import com.pokedex.pokedex.Model.Util.Localizable;

public class BerryFlavor implements PokeApiResource, Localizable {

	private Integer id;
	private String name;
	private List<FlavorBerryMap> barries;
	private NamedApiResource<ContestType> contestType;
	private List<Name> names;
	
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
	public List<FlavorBerryMap> getBarries() {
		return barries;
	}
	public void setBarries(List<FlavorBerryMap> barries) {
		this.barries = barries;
	}
	public NamedApiResource<ContestType> getContestType() {
		return contestType;
	}
	public void setContestType(NamedApiResource<ContestType> contestType) {
		this.contestType = contestType;
	}
	public List<Name> getNames() {
		return names;
	}
	public void setNames(List<Name> names) {
		this.names = names;
	}
	
}
