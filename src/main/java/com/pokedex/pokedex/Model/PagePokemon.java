package com.pokedex.pokedex.Model;

import java.util.List;

public class PagePokemon {

    private Integer count;
    private String nextPageUrl;
    private String previousPageUrl;
    private List<Result> contain;

    // Constructor
    public PagePokemon(String nextPageUrl, String previousPageUrl, List<Result> contain) {
        this.nextPageUrl = nextPageUrl;
        this.previousPageUrl = previousPageUrl;
        this.contain = contain;
    }

    // Getter y Setter para nextPageUrl
    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    // Getter y Setter para previousPageUrl
    public String getPreviousPageUrl() {
        return previousPageUrl;
    }

    public void setPreviousPageUrl(String previousPageUrl) {
        this.previousPageUrl = previousPageUrl;
    }

    // Getter y Setter para contain
    public List<Result> getContain() {
        return contain;
    }

    public void setContain(List<Result> contain) {
        this.contain = contain;
    }
}
