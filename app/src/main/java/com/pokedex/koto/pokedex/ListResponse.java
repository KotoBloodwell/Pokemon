package com.pokedex.koto.pokedex;

/**
 * Created by KOTO on 11/07/2017.
 */

import java.util.List;

import javax.xml.transform.Result;

public class ListResponse {

    private int count;
    private Object previous;
    private List<Result> results = null;
    private String next;

    /**
     * No args constructor for use in serialization
     *
     */
    public ListResponse() {
    }

    /**
     *
     * @param results
     * @param previous
     * @param count
     * @param next
     */
    public ListResponse(int count, Object previous, List<Result> results, String next) {
        super();
        this.count = count;
        this.previous = previous;
        this.results = results;
        this.next = next;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

}
