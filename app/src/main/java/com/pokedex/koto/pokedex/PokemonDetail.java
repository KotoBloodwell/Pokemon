package com.pokedex.koto.pokedex;

/**
 * Created by KOTO on 17/07/2017.
 */

public class PokemonDetail {

    private Form forms[];
    private String name;


    private long weight;

    public PokemonDetail(Form[] forms, String name, long weight, Ability[] abilities) {
        this.forms = forms;
        this.name = name;
        this.weight = weight;
        this.abilities = abilities;
    }

    public Ability[] getAbilities() {
        return abilities;
    }

    public void setAbilities(Ability[] abilities) {
        this.abilities = abilities;
    }

    private Ability abilities[];
  //  private List<Ability> abilities = null;

    //  private Stat stats[];
    // private Move moves[];


    public PokemonDetail() {

    }

    public Form[] getForms() {
        return forms;
    }

    public void setForms(Form[] forms) {
        this.forms = forms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }


    public class Form {
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

        private String url;
        private String name;

        public Form(String url, String name){
            this.url = url;
            this.name = name;
        }
    }






}
