package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //jsut an arraylist to store users
        ArrayList<User> users = new ArrayList<>();
        Scanner reader = new Scanner(System.in);

        label:
        while (true) {
            //print mini-menu with 4 options + quit
            System.out.println("1-createUser");
            System.out.println("2-changePin");
            System.out.println("3-transfer");
            System.out.println("4-deposit");

            String command = ask(reader, "Option?");

            //to quit the loop write Quit
            switch (command) {
                case "Quit":
                    break label;
                case "createUser":
                    //call-operation to create new user
                    createUser(reader, users);
                    break;
                case "changePin":
                    //call-operation to change pin
                    changePin(reader, users);
                    break;
                case "transfer":
                    //call-operation to make transfer
                    transfer(reader, users);
                    break;
                case "deposit":
                    //call-operation to deposit, to charge, to add some money to the card
                    deposit(reader, users);
                    break;
                default:
                    System.out.println("Unknown command!");
                    break;
            }
        }
        //Exit program
        System.out.println("Bye, bye, you have created " + users.size() + " users: " + users);
    }

    //************************************************************************************
    //************************************** features ************************************
    //************************************************************************************

    public static void createUser(Scanner reader, ArrayList users) {
        //Let s introduce data to create User
        String name = ask(reader, "Name?");
        String surname = ask(reader, "Surname?");
        int age = Integer.parseInt(ask(reader, "Age?"));
        //Let s introduce data to create User's card
        long number = Long.parseLong(ask(reader, "Number Card?"));
        double aomunt = Double.parseDouble(ask(reader, "Amount?"));
        String type = ask(reader, "Type?");
        //Integer pin = Integer.valueOf(ask(reader, "Pin Card?"));

        //Let s create User object with previous data
        User createdUser = new User(name, surname, age, new Card(number, aomunt, type));
        System.out.println("User created: " + createdUser);
        //Let s add this new User object to the main (and just one) array
        users.add(createdUser);
        System.out.println("User added to users: " + users);

    }

    public static void changePin(Scanner reader, ArrayList<User> users) {
        //ask for card number and check if this card number exists within users
        //and get the index from the array, if it does not exists, get -1
        int number = Integer.parseInt(ask(reader, "Number Card?"));
        int position = isCardNumber(number, users);

        //if card number exists make the change Pin operation
        if (position > -1) {
            updatePin(reader, users, position);
            //if card number does not exist monitor this to user
        } else {
            System.out.println("This credit card number ( #: " + number + " ) does not exist");
        }
    }

    public static void transfer(Scanner reader, ArrayList users) {
        //ask for both credit card numbers and make a transfer
        int originCardNumber = Integer.valueOf(ask(reader, "Number Card from?"));
        int originPosition = isCardNumber(originCardNumber, users);
        int destinationCardNumber = Integer.parseInt(ask(reader, "Number Card to?"));
        int destinationPosition = isCardNumber(destinationCardNumber, users);

        if (originPosition > -1 && destinationPosition > -1) {
            Double amount = Double.valueOf(ask(reader, "Amount?"));
            boolean isMoney = isAmount(reader, users, originPosition, amount);
            if (isMoney) {
                //now it is possible to make a transer, call makeTransfer
                makeTransfer(originPosition, destinationPosition, amount, users);
            } else {
                System.out.println("Check if credit card has not got enough money to make a transfer ...");
            }
        } else {
            System.out.println("Check if credit card numbers are right ...");
        }
    }

    public static void deposit(Scanner reader, ArrayList users) {

    }

    //************************************************************************************
    //************************************** utils ***************************************
    //************************************************************************************

    public static String ask(Scanner reader, String string) {
        System.out.println(string);
        return reader.nextLine();
    }

    /*public static boolean isCardNumber (int cardNumber, ArrayList<User> users){
        boolean isCard = false;
        for (User user : users){
            if (user.getCard().getNumber() == cardNumber)  isCard= true;
         }
        return isCard;
    }*/

    public static int isCardNumber(int cardNumber, ArrayList<User> users) {
        //find out if cardNumber exists in users
        int positon = -1;
        for (User user : users) {
            if (user.getCard().getNumber() == cardNumber) positon = users.indexOf(user);
        }
        return positon;
    }

    public static void updatePin(Scanner reader, ArrayList<User> users, int position) {
        //just ask for new pin and set new pin to users-user-card-pin
        int newPin = Integer.parseInt(ask(reader, "New Pin?"));
        int oldPin = users.get(position).getCard().getPin();
        users.get(position).getCard().setPin(newPin);
        System.out.println("Pin changed success. From old Pin number ( #: " + oldPin + " ) to new Pin number ( # " + newPin + " )");

    }

    public static boolean isAmount(Scanner reader, ArrayList<User> users, int position, Double amount) {
        //check if is enough money in origin card
        return users.get(position).getCard().getAmount() >= amount;
    }

    public static void makeTransfer(int originPosition, int destinationPosition, Double amount, ArrayList<User> users) {
        //rest this qty amount from origin
        users.get(originPosition).getCard().removeAmount(amount);
        //add this qty amount from destination
        users.get(destinationPosition).getCard().addAmount(amount);
    }

}