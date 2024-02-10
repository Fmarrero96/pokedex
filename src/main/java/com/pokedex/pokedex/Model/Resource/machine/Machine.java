package com.pokedex.pokedex.Model.Resource.machine;

import com.pokedex.pokedex.Model.Resource.NamedApiResource;
import com.pokedex.pokedex.Model.Resource.item.Item;
import com.pokedex.pokedex.Model.Resource.move.Move;
import com.pokedex.pokedex.Model.Resource.versiongroup.VersionGroup;

public class Machine {

	private Integer id;
	private NamedApiResource<Item> item;
	private NamedApiResource<Move> move;
	private NamedApiResource<VersionGroup> versionGroup;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public NamedApiResource<Item> getItem() {
		return item;
	}
	public void setItem(NamedApiResource<Item> item) {
		this.item = item;
	}
	public NamedApiResource<Move> getMove() {
		return move;
	}
	public void setMove(NamedApiResource<Move> move) {
		this.move = move;
	}
	public NamedApiResource<VersionGroup> getVersionGroup() {
		return versionGroup;
	}
	public void setVersionGroup(NamedApiResource<VersionGroup> versionGroup) {
		this.versionGroup = versionGroup;
	}
	
}
