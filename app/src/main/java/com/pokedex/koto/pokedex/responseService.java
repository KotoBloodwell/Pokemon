package com.pokedex.koto.pokedex;

/**
 * Created by KOTO on 11/07/2017.
 */

public class responseService {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(int base_experience) {
        this.base_experience = base_experience;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean is_default() {
        return is_default;
    }

    public void setIs_default(boolean is_default) {
        this.is_default = is_default;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    int id;
    String name;
    int base_experience;
    int height;
    boolean is_default;
    int order;
    int weight;

}
