package com.akvelon.bicycleProject.model;

/**
 * Created by maksym.skrypnyk
 */


public class Type extends Entity<Integer>{
    private String name;
    private String description;

    public Type(){

    }

    public Type(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Type{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
