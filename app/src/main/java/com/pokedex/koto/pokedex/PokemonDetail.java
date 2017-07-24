package com.pokedex.koto.pokedex;

import java.util.List;

/**
 * Created by KOTO on 17/07/2017.
 */

public class PokemonDetail {

    private Form forms[];
    private String name;


    private long weight;

    public PokemonDetail(Form[] forms, String name, long weight, Abilities[] abilities) {
        this.forms = forms;
        this.name = name;
        this.weight = weight;
        this.abilities = abilities;
    }

    public Abilities[] getAbilities() {
        return abilities;
    }

    public void setAbilities(Abilities[] abilities) {
        this.abilities = abilities;
    }

    private Abilities abilities[];
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

   /* public PokemonDetail(Form[] forms, String name, long weight) {
        this.forms = forms;
        this.name = name;
        this.weight = weight;
    }*/




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

    public class Abilities {
        public Abilities() {

        }

        public Abilities(int slot, boolean isHidden, Ability_ ability) {
            this.slot = slot;
            this.isHidden = isHidden;
            this.ability = ability;
        }

        public int getSlot() {
            return slot;
        }

        public void setSlot(int slot) {
            this.slot = slot;
        }

        public boolean isHidden() {
            return isHidden;
        }

        public void setHidden(boolean hidden) {
            isHidden = hidden;
        }

        public Ability_ getAbility() {
            return ability;
        }

        public void setAbility(Ability_ ability) {
            this.ability = ability;
        }

        private int slot;
        private boolean isHidden;
        private Ability_ ability;

        public class Ability_ {
            public Ability_(String url, String name) {
                this.url = url;
                this.name = name;
            }
            public Ability_() {

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

            private String url;
            private String name;
        }

        }




}
