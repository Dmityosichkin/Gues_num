package com.company;

import java.io.OptionalDataException;
import java.util.*;

public class Main {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);
    static List<GameResult> results = new ArrayList<>();


    public static void main(String[] args) {
        String answer;
        int scanNum = 0;
        do {

            System.out.println("What is your name?");
            String userName = scan.next();
            long t1 = System.currentTimeMillis();


            int myNum = rand.nextInt(100) + 1;
            System.out.println(myNum);
            boolean userLost = true;
            for (int i = 1; i < 10; i += 1) {
                System.out.println("Try #" + i);
                int userNum = askNUM();
                if (myNum > userNum) {
                    System.out.println("a littel bit more");
                }
                if (myNum < userNum) {
                    System.out.println("slightly less");

                }
                if (myNum == userNum) {
                    System.out.println("You Win");
                    long t2 = System.currentTimeMillis();

                    userLost = false;
                    GameResult r = new GameResult();
                    r.name = userName;
                    r.triesCount = i;
                    r.time = (t2 - t1)/1000;
                    results.add(r);
                    break;
                }
            }
            if (userLost) {
                System.out.println("You lost");

            }
            System.out.println("Do you want play again? (y/n)");
            answer = askYN();


        } while (answer.equals("y"));

        showResults();
        System.out.println("good bye!");
    }
    private static void showResults() {
        for (GameResult r : results){
            System.out.println(r.name + " Scors: " +r.triesCount + " Time: "+ r.time+ "ms");
    }

}

    static String askYN() {
        String answer;
        do {


            answer = scan.next();
            if (!answer.equals("y") && !answer.equals("n")) {
                System.out.println("you can enter only 'y' or 'n' ");
//                 continue; // return cycle again
            } else {
                break;
            }
        } while (true);
        return answer;
    }

    static int askNUM() {
        int answer;
        do {
            try {
                answer = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("This isn't a number");
                scan.next();
                continue;
            }

            if (answer < 1 || answer > 100) {
                System.out.println("you can enter numbers from 1 to 100");
            } else {
                break;
            }
        }
        while (true);
        return answer;
    }
}


