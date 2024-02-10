package com.pokedex.pokedex.Model.Resource.berryflavor;

import com.pokedex.pokedex.Model.Resource.NamedApiResource;
import com.pokedex.pokedex.Model.Resource.berry.Berry;

public class FlavorBerryMap {

	private Integer potency;
	private NamedApiResource<Berry> berry;
	
	public Integer getPotency() {
		return potency;
	}
	public void setPotency(Integer potency) {
		this.potency = potency;
	}
	public NamedApiResource<Berry> getBerry() {
		return berry;
	}
	public void setBerry(NamedApiResource<Berry> berry) {
		this.berry = berry;
	}
	
}
