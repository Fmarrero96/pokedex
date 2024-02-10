package com.pokedex.pokedex.Model.Resource.item;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemSprites {

	private String imageUrl;

	@JsonProperty("default")
	public String getImageUrl() {
		return imageUrl;
	}

	@JsonProperty("default")
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
