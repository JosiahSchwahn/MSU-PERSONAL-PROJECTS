package com.company;

public class Key_values {

    //each key value object has a key and name ex. 123123 "Josiah"
    int key;
    String name;

    //sets data of the object (constructor)
    public Key_values(int key, String name){

        this.key = key;

        this.name = name;

    }

    //method to recieve key
    public int getKey(){

        return this.key;

    }
    //method to recieve name
    public String getName(){

        return this.name;

    }
    // NOTE: no need to setters, all data is final when placed into hash table
}
