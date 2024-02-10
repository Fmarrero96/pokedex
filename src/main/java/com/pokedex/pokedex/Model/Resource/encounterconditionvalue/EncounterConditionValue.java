package com.pokedex.pokedex.Model.Resource.encounterconditionvalue;

import java.util.List;

import com.pokedex.pokedex.Model.Resource.Name;
import com.pokedex.pokedex.Model.Resource.NamedApiResource;
import com.pokedex.pokedex.Model.Resource.PokeApiResource;
import com.pokedex.pokedex.Model.Resource.encountercondition.EncounterCondition;
import com.pokedex.pokedex.Model.Util.Localizable;

public class EncounterConditionValue implements PokeApiResource, Localizable {

	private Integer id;
	private String name;
	private NamedApiResource<EncounterCondition> condition;
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
	public NamedApiResource<EncounterCondition> getCondition() {
		return condition;
	}
	public void setCondition(NamedApiResource<EncounterCondition> condition) {
		this.condition = condition;
	}
	public List<Name> getNames() {
		return names;
	}
	public void setNames(List<Name> names) {
		this.names = names;
	}
	
}
