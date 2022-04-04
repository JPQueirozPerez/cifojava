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

    //methods non-static
    public boolean idAdult(){
        return getAge() >= 18;
    }

    public String sayHello(){
        return "Hello";
    }

    public String sayHelloPerson(){
        return "Hello " + getName();
    }

    public void printName(){
        System.out.println("This person's name is: " + getName() + " " + getSurname());

        Main.hello();
    }

    public void printPerson(){
        System.out.println(this.getName() + " " + this.getSurname() + " " + this.car.make + " " + this.car.year + " " + this.dogs.get(0).name);
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public ArrayList<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(ArrayList<Dog> dogs) {
        this.dogs = dogs;
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
