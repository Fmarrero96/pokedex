package com.pokedex.pokedex.Model.Resource.contesttype;

import java.util.List;

import com.pokedex.pokedex.Model.Resource.PokeApiResource;

public class ContestType implements PokeApiResource {

	private Integer id;
	private String name;
	private List<ContestName> names;
	
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
	public List<ContestName> getNames() {
		return names;
	}
	public void setNames(List<ContestName> names) {
		this.names = names;
	}
	
}
