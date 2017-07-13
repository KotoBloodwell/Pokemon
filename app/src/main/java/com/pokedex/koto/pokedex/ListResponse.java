package com.pokedex.koto.pokedex;

/**
 * Created by KOTO on 11/07/2017.
 */

import java.util.List;

public class ListResponse {

    private int count;
    private String previous;
    private List<PokemonItem> results = null;
    private String next;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<PokemonItem> getResults() {
        return results;
    }

    public void setResults(List<PokemonItem> results) {
        this.results = results;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

}
