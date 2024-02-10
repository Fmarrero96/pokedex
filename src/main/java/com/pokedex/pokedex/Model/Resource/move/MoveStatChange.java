package com.pokedex.pokedex.Model.Resource.move;

import com.pokedex.pokedex.Model.Resource.NamedApiResource;
import com.pokedex.pokedex.Model.Resource.stat.Stat;

public class MoveStatChange {

	private Integer change;
	private NamedApiResource<Stat> stat;
	
	public Integer getChange() {
		return change;
	}
	public void setChange(Integer change) {
		this.change = change;
	}
	public NamedApiResource<Stat> getStat() {
		return stat;
	}
	public void setStat(NamedApiResource<Stat> stat) {
		this.stat = stat;
	}
	
}
