package com.revature.ismellu.ui;

import com.revature.ismellu.daos.CrudDAO;
import com.revature.ismellu.daos.ismelluDAO;
import com.revature.ismellu.daos.ReviewDAO;
import com.revature.ismellu.models.ismellu;
import com.revature.ismellu.models.Review;

import java.util.List;
import java.util.Scanner;

public class ismelluMenu implements IMenu {
    CrudDAO<ismellu> ismelluDAO = new ismelluDAO();
    CrudDAO<Review> reviewCrudDAO = new ReviewDAO();

    @Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while (!exit) {
            System.out.println("\nWelcome to I Smell U menu!");
            System.out.println("[1] Cologne "); //add item "View all was here"
            System.out.println("[2] Perfume "); //add item
            System.out.println("[3] Candles "); //add item
            System.out.println("[x] Exit");

            System.out.print("\nEnter: ");
            input = scan.next().charAt(0);

            switch (input) {
                case '1':
                    viewAllismellu();
                    break;
                case '2':
                    break;
                case '3':
                    createismellu();
                    break;
                case 'x':
                    exit = true;
                    break;
                default:
                    System.out.println("\nInvalid input!");
                    break;
            }
        }
    }

    private void createismellu() {
        char input = ' ';
        boolean exit = false;

        Scanner scan = new Scanner(System.in);
        Ismellu ismellu = new Ismellu();

        /* loop to ask user to enter in restaurant */
        while (!exit) {
            boolean confirm = false;

            /* get restaurant name */
            System.out.print("\nEnter in restaurant name: "); //add an item
            ismellu.setName(scan.next().toLowerCase());

            /* get restaurant city */
            System.out.print("\nEnter in restaurant city: "); //add an item
            restaurant.setCity(scan.next().toLowerCase());

            /* get restaurant state */
            System.out.print("\nEnter in restaurant state: "); //add an item
            restaurant.setState(scan.next().toLowerCase());

            /* loop to confirm */
            while (!confirm) {
                System.out.println("\nIs this correct? (y/n)");
                System.out.println(restaurant);

                System.out.print("\nEnter: ");
                input = scan.next().charAt(0);

                switch (input) {
                    case 'y':
                        restaurantDAO.save(restaurant);
                        System.out.println("\nRestaurant created successfully!");
                        exit = true;
                        confirm = true;
                        break;
                    case 'n':
                        confirm = true;
                        break;
                    default:
                        System.out.println("\nInvalid input!");
                        break;
                }
            }
        }
    }

    private void viewAllismellu() {
        int input = 0;
        Scanner scan = new Scanner(System.in);
        List<ismellu> restList = ismelluDAO.findAll();

        /* loop through restaurant list and print out the restaurants */
        System.out.println();
        for (int i = 0; i < restList.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + restList.get(i).getName());
        }

        /* loop to ask user to enter a restaurant */
        while (true) {
            System.out.print("\nSelect a restaurant to view reviews: ");

            /* get the user restaurant selection */
            input = scan.nextInt() - 1;

            /* if the input is not of any restaurant, printout invalid input */
            if (input > restList.size()) {
                System.out.println("\nInvalid input");
            } else {

                /* store the reviews of that restaurant into a review list */
                List<Review> revList = reviewCrudDAO.findAllById(restList.get(input).getId());

                /* printout the selected restaurant */
                System.out.println(restList.get(input));

                /* printout all the reviews for that restaurant */
                for (Review rev : revList) {
                    System.out.println(rev);
                }
                break;
            }
        }
    }
}