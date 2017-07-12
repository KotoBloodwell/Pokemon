package com.pokedex.koto.pokedex;

/**
 * Created by KOTO on 11/07/2017.
 */

public class PokemonResponse {

    private String url;
    private String name;

    /**
     * No args constructor for use in serialization
     *
     */
    public PokemonResponse() {
    }

    /**
     *
     * @param name
     * @param url
     */
    public PokemonResponse(String url, String name) {
        super();
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}