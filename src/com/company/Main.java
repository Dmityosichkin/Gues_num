package com.company;

import java.io.OptionalDataException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        int myNum = rand.nextInt(100) + 1;
        System.out.println(myNum);
        boolean userLost = true;
        for (int i = 1 ; i < 10; i += 1) {
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
        if (userLost == true)
        System.out.println("You lost");
    }
}
