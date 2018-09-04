package com.company;

import java.io.OptionalDataException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        String answer;
        int scanNum = 0;
        do {

            int myNum = rand.nextInt(100) + 1;
            System.out.println(myNum);
            boolean userLost = true;
            for (int i = 1; i < 10; i += 1) {
                System.out.println("Try #" + i);
                int userNum = scan.nextInt();
                if (myNum > userNum) {
                    System.out.println("a littel bit more");
                }
                if (myNum < userNum) {
                    System.out.println("slightly less");

                }
                if (myNum == userNum) {
                    System.out.println("good");
                    userLost = false;
                    break;
                }
            }
            if (userLost) {
                System.out.println("You lost");

            }
            System.out.println("Do you want play again? (y/n)");
            answer = askYN();


        } while (answer.equals("y"));
        System.out.println("good bye!");
    }

    static String askYN() {
        String answer;
        do {
            answer = scan.next();
            if (!answer.equals("y")&& !answer.equals("n")) {
                System.out.println("you can enter only 'y' or 'n' ");
                continue;
            } else {
                break;
            }
        } while (true);
        return answer;
    }
}

