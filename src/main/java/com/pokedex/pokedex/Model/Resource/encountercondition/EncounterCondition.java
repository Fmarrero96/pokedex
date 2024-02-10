package com.pokedex.pokedex.Model.Resource.encountercondition;

import java.util.List;

import com.pokedex.pokedex.Model.Resource.Name;
import com.pokedex.pokedex.Model.Resource.NamedApiResource;
import com.pokedex.pokedex.Model.Resource.PokeApiResource;
import com.pokedex.pokedex.Model.Resource.encounterconditionvalue.EncounterConditionValue;
import com.pokedex.pokedex.Model.Util.Localizable;

public class EncounterCondition implements PokeApiResource, Localizable {

	private Integer id;
	private String name;
	private List<Name> names;
	private List<NamedApiResource<EncounterConditionValue>> values;
	
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
	public List<Name> getNames() {
		return names;
	}
	public void setNames(List<Name> names) {
		this.names = names;
	}
	public List<NamedApiResource<EncounterConditionValue>> getValues() {
		return values;
	}
	public void setValues(List<NamedApiResource<EncounterConditionValue>> values) {
		this.values = values;
	}
	
}
