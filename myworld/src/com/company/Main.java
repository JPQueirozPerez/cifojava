package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static  Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        ArrayList<User> users = new ArrayList<>();
        
            menuOptions();

            //print mini-menu with 4 options

            //call-operation to createUserInputOutput
            //call-operation to create new user

            //call-operation to changePinInputOutput
            //call-operation to change pin

            //call-operation to transferInputOutput
            //call-operation to make transfer

            //call-operation to depositInputOutput
            //call-operation to deposit, to charge, to add some money to the card

    }

    public static void menu() {
        System.out.println("MENU");
        System.out.println(" ");
        System.out.println("0. Quit");
        System.out.println("1. Create user");
        System.out.println("2. Change pin");
        System.out.println("3. Transfer");
        System.out.println("4. Deposit");
        System.out.println(" ");
        System.out.println("Choose an option:");
    }

    public static void menuOptions(){
        while (true) {
            boolean exit = false;
            menu();
            int value = reader.nextInt();

            switch (value) {
                case 0 -> exit = true;
                case 1 -> createUserInputOutput();
                case 2 -> changePinInputOutput();
                case 3 -> transferInputOutput();
                case 4 -> depositInputOutput();
                default -> System.out.println("Invalid option\n");
            }
            if (exit) break;
        }
    }

    public static void createUser(){

    }

    public static void changePin(){

    }

    public static void transfer(){

    }

    public static void deposit(){

    }

    public static void createUserInputOutput(){

    }

    public static void changePinInputOutput(){

    }

    public static void transferInputOutput(){

    }

    public static void depositInputOutput(){

    }
}
