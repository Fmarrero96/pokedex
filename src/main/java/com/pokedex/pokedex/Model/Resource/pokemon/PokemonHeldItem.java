package com.pokedex.pokedex.Model.Resource.pokemon;

import java.util.List;

import com.pokedex.pokedex.Model.Resource.NamedApiResource;
import com.pokedex.pokedex.Model.Resource.item.Item;

public class PokemonHeldItem {

	private NamedApiResource<Item> item;
	private List<PokemonHeldItemVersion> versionDetails;
	
	public NamedApiResource<Item> getItem() {
		return item;
	}
	public void setItem(NamedApiResource<Item> item) {
		this.item = item;
	}
	public List<PokemonHeldItemVersion> getVersionDetails() {
		return versionDetails;
	}
	public void setVersionDetails(List<PokemonHeldItemVersion> versionDetails) {
		this.versionDetails = versionDetails;
	}
	
}
