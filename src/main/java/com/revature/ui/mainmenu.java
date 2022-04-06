package com.revature.ismellu.ui;

import java.util.Scanner;

/* implements IMenu to inherit start() method */
public class MainMenu implements IMenu {

    /* override the start method to add main menu functionality */
    @Override
    public void start() {
        /* get user input */
        char input = ' ';

        /* exit flag */
        boolean exit = false;

        /* to get user input */
        Scanner scan = new Scanner(System.in);

        /* while exit is not true */
        while (!exit) {
            System.out.println("\nWelcome to I smell U!");
            System.out.println("[1] Go to I smell U menu");
            System.out.println("[2] Go to review menu");
            System.out.println("[x] Exit");

            System.out.print("\nEnter: ");
            input = scan.next().charAt(0);

            /* switch statement for user input */
            switch (input) {
                /* if user enter 1 */
                case '1':
                    new RestaurantMenu().start();
                    break;

                /* if user enter 2 */
                case '2':
                    break;

                /* if user enter x */
                case 'x':
                    exit = true;
                    break;

                /* if user enter anything that is not 1,2, or x */
                default:
                    System.out.println("\nInvalid input!");
                    break;
            }
        }
    }
}