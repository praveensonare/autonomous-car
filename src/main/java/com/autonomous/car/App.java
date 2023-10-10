package com.autonomous.car;
import java.util.Scanner;

/**
 * Main entry point of application.
 */
public class App {
    public static void main(String[] args) {
        mainMenu();
        /*
        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream
        System.out.print("Enter first number- ");
        int a= sc.nextInt();
        System.out.print("Enter second number- ");
        int b= sc.nextInt();
        System.out.print("Enter direction- ");
        String direction = sc.next();

        System.out.println("Entered direction "+direction);

         */
    }

    public static void mainMenu() {
        while(true) {
            GameService.getInstance().init();
            GameService.getInstance().startupMenu();
            GameService.getInstance().subMenu();
        }
    }
}
