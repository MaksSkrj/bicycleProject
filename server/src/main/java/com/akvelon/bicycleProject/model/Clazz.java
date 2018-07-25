package com.akvelon.bicycleProject.model;


/**
 * Created by maksym.skrypnyk
 */


public enum Clazz {
    H, M, L;

    public static Clazz getByName(String name){
        return   Clazz.valueOf(name);
    }
}
