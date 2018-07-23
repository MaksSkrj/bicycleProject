package com.akvelon.bicycleProject.model;

/**
 * Created by maksym.skrypnyk
 */


public class Bike extends Entity<Integer> {
    private String name;
    private String colour;
    private double weight ;
    private int type_id;
    private int manufacturer_id;
    private double price;
    private int views;

    public Bike(){

    }

    public Bike(String name, String colour, double weight, int type_id, int manufacturer_id, double price, int views) {
        this.name = name;
        this.colour = colour;
        this.weight = weight;
        this.type_id = type_id;
        this.manufacturer_id = manufacturer_id;
        this.price = price;
        this.views = views;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getManufacturer_id() {
        return manufacturer_id;
    }

    public void setManufacturer_id(int manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", weight=" + weight +
                ", type_id=" + type_id +
                ", manufacturer_id=" + manufacturer_id +
                ", price=" + price +
                ", views=" + views +
                '}';
    }
}
