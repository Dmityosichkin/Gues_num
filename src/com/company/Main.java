package com.company;

import java.io.*;
import java.util.*;

public class Main {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);
    static List<GameResult> results = new ArrayList<>();


    public static void main(String[] args) {

        loadResults();
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
                    r.time = (t2 - t1);
                    results.add(r);
                    results.sort(Comparator.<GameResult>comparingInt(r0 -> r0.triesCount)
                             .thenComparingLong(r0-> r0.time));
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
        saveResults();


        System.out.println("good bye!");
    }

    private static void loadResults() {
        File file = new File("top_scores.txt");
        try (Scanner in = new Scanner(file)) {

            while (in.hasNext()) {
                GameResult result = new GameResult();
                result.name = in.next();
                result.triesCount = in.nextInt();
                result.time = in.nextLong();
                results.add(result);
            }

        } catch (IOException e) {
            System.out.println("Cannot load from file");
        }
    }

    private static void saveResults() {
        File file = new File("top_scores.txt");
        try (PrintWriter out = new PrintWriter(file)) {
            for (GameResult r : results) {
                out.printf("%s %d %d\n", r.name, r.triesCount, r.time);
            }

        } catch (IOException e) {
            System.out.println("Cannot save file");
        }
    }

// ***first metod***
//    private static void showResults() {
//        int count = 0;
//        for (GameResult r : results) {
//            System.out.printf("%s - %d - %dsec\n", r.name, r.triesCount, r.time / 1000);
//            count++;
//            if (count == 5) {
//                break;*/
//            }
//        }
//
//    }

// ***Second metod***

//    private static void showResults() {
//
//        int count = 5;
//        if (results.size() < 5) {
//            count = results.size();
//        }
//        for (int i = 0; i < count; i++) {
//            GameResult r = results.get(i);
//            System.out.printf("%s - %d - %dsec\n", r.name, r.triesCount, r.time / 1000);
//        }
//    }

// *** final metod*** function programming
    private static void showResults() {
        results.stream()
//                .filter(r -> r.name.equals("Dima"))
//                .sorted(Comparator.<GameResult>comparingInt(r -> r.triesCount)
//                                  .thenComparingLong(r-> r.time))
                .limit(5)
                .forEach(r -> {
                    System.out.printf("%s - %d - %dsec\n", r.name, r.triesCount, r.time / 1000);
                });
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


