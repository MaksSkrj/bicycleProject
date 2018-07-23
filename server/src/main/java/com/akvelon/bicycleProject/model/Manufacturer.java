package com.akvelon.bicycleProject.model;

import java.time.Year;

/**
 * Created by maksym.skrypnyk
 */


public class Manufacturer extends Entity<Integer> {
    private String name;
    private String country;
    private int yearOfFoundation;
    private String webSite;

    public Manufacturer(){

    }

    public Manufacturer(String name, String country, int yearOfFoundation, String webSite) {
        this.name = name;
        this.country = country;
        this.yearOfFoundation = yearOfFoundation;
        this.webSite = webSite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", webSite='" + webSite + '\'' +
                '}';
    }
}
