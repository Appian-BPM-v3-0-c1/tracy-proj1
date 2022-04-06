package com.revature.ismellu.ui;
import java.util.Scanner; //unsure if I need this

public class ismellu {

    public void startReview() {

        char user = ' ';
        int userattract = a;
        int userrepel = r;
        int neutral= n;

        System.out.println("Welcome to I smell U");

        while (user != 'x') {

            char user = ; //user needs to pick a letter
            Scanner scan = new Scanner(System.in);

            System.out.println("\nPick r (rep) a (attract) n (netrual) x (exit).");

            user = scan.nextLine().charAt(0);

            if (user ) { //if user picks r, a, n, ask user explain or comment
                System.out.println("repel");
                System.out.println("attract");
                System.out.println("neutral");
            } else if (

        }

        System.out.println("\nThank You");

    }

    public int getRandomNumber() {
        return (int) (Math.random() * 3);
    }
}

}