package com.pokedex.pokedex.Model.Resource.versiongroup;

import java.util.List;

import com.pokedex.pokedex.Model.Resource.NamedApiResource;
import com.pokedex.pokedex.Model.Resource.PokeApiResource;
import com.pokedex.pokedex.Model.Resource.generation.Generation;
import com.pokedex.pokedex.Model.Resource.movelearnmethod.MoveLearnMethod;
import com.pokedex.pokedex.Model.Resource.pokedex.Pokedex;
import com.pokedex.pokedex.Model.Resource.region.Region;
import com.pokedex.pokedex.Model.Resource.version.Version;

public class VersionGroup implements PokeApiResource {

	private Integer id;
	private String name;
	private Integer order;
	private NamedApiResource<Generation> generation;
	private List<NamedApiResource<MoveLearnMethod>> moveLearnMethods;
	private List<NamedApiResource<Pokedex>> pokedexes;
	private List<NamedApiResource<Region>> regions;
	private List<NamedApiResource<Version>> versions;
	
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
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public NamedApiResource<Generation> getGeneration() {
		return generation;
	}
	public void setGeneration(NamedApiResource<Generation> generation) {
		this.generation = generation;
	}
	public List<NamedApiResource<MoveLearnMethod>> getMoveLearnMethods() {
		return moveLearnMethods;
	}
	public void setMoveLearnMethods(List<NamedApiResource<MoveLearnMethod>> moveLearnMethods) {
		this.moveLearnMethods = moveLearnMethods;
	}
	public List<NamedApiResource<Pokedex>> getPokedexes() {
		return pokedexes;
	}
	public void setPokedexes(List<NamedApiResource<Pokedex>> pokedexes) {
		this.pokedexes = pokedexes;
	}
	public List<NamedApiResource<Region>> getRegions() {
		return regions;
	}
	public void setRegions(List<NamedApiResource<Region>> regions) {
		this.regions = regions;
	}
	public List<NamedApiResource<Version>> getVersions() {
		return versions;
	}
	public void setVersions(List<NamedApiResource<Version>> versions) {
		this.versions = versions;
	}
	
}
