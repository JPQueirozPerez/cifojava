package com.company;

import java.util.ArrayList;

public class Person {

    private String name;
    private String surname;
    private int age;
    private boolean vegan;
    Car car;
    ArrayList<Dog> dogs = new ArrayList<Dog>();

    public Person(){}

    //constructor
    public Person(String name, String surname, int age, boolean vegan, Car car){
        this.name  = name;
        this.surname = surname;
        this.age = age;
        this.vegan = vegan;
        this.car = car;
        this.dogs = new ArrayList<Dog>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }
}
