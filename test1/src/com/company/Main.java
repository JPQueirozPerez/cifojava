package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here

        hello();

        Person david = new Person("David", "Perez", 18, false, new Car("Jaguar", 1966));

        Person alex = new Person();

        Car citroen = new Car("Citroen Picasso", 2010);

        alex.setName("Alex");
        alex.setSurname("Ross");
        //alex.setAge(25);
        alex.setVegan(true);
        alex.setCar(citroen);
        alex.dogs.add(new Dog("Toby"));
        alex.printPerson();

        david.dogs.add(new Dog("Rex"));
        david.printPerson();

        /*Scanner scanner = new Scanner(System.in);
        System.out.println("David's surname: ");
        String message = scanner.nextLine();
        david.setSurname(message);

        boolean davidAdult = david.idAdult();

        boolean alexAdult = alex.idAdult();

        david.printName();

        System.out.println("Age of " + alex.getName() + ": " + alex.getAge());

        System.out.println("Person: " + david.getName());
        System.out.println("Is " + david.getName() + " an adult? " + davidAdult);
        System.out.println(david.sayHelloPerson());
        System.out.println("Is " + alex.getName() + " an adult? " + alexAdult);*/

    }

    public static void hello(){

        System.out.println("Hello I am a static method");
    }
}
