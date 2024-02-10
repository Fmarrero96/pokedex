package com.pokedex.pokedex.Model.Resource.locationarea;

import java.util.List;

import com.pokedex.pokedex.Model.Resource.NamedApiResource;
import com.pokedex.pokedex.Model.Resource.encountermethod.EncounterMethod;

public class EncounterMethodRate {

	private NamedApiResource<EncounterMethod> encounterMethod;
	private List<EncounterVersionDetails> versionDetails;
	
	public NamedApiResource<EncounterMethod> getEncounterMethod() {
		return encounterMethod;
	}
	public void setEncounterMethod(NamedApiResource<EncounterMethod> encounterMethod) {
		this.encounterMethod = encounterMethod;
	}
	public List<EncounterVersionDetails> getVersionDetails() {
		return versionDetails;
	}
	public void setVersionDetails(List<EncounterVersionDetails> versionDetails) {
		this.versionDetails = versionDetails;
	}
	
}
