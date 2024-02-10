package com.pokedex.pokedex.Model.Resource;

import com.pokedex.pokedex.Model.Resource.version.Version;

public class VersionGameIndex {

	private Integer gameIndex;
	private NamedApiResource<Version> version;
	
	public Integer getGameIndex() {
		return gameIndex;
	}
	public void setGameIndex(Integer gameIndex) {
		this.gameIndex = gameIndex;
	}
	public NamedApiResource<Version> getVersion() {
		return version;
	}
	public void setVersion(NamedApiResource<Version> version) {
		this.version = version;
	}
	
}
