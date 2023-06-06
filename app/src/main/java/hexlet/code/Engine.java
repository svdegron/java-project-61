package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Eval;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class Engine {

    public static void start(String[][] content, String description, Scanner scanner) {
        String userName = Cli.greeting(scanner);

        System.out.println(description);

        final int question = 0;
        final int answer = 1;
        int round = 0;
        boolean repeat = false;
        String userAnswer = "";

        do {
            System.out.print(content[round][question]);

            userAnswer = scanner.next();
            repeat = userAnswer.equals(content[round][answer]);

            if (repeat) {
                System.out.println("Correct!");
            } else {
                System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again,"
                        + " %s!", userAnswer, content[round][answer], userName));
            }

            round++;
        } while (repeat && round < content.length);

        if (repeat && round == content.length) {
            System.out.println(String.format("Congratulations, %s!", userName));
        }
    }

    public static void chooseGame(Scanner sc, String gameNumber) {
        //
        final int countRounds = 3;
        int currentRound = 0;
        boolean repeatGame = false;
        String userName = Cli.greeting(sc);

        do {
            switch (gameNumber) {
                case "2":
                    repeatGame = Eval.startGame(sc, userName);
                    break;
                case "3":
                    repeatGame = Calc.startGame(sc, userName);
                    break;
                case "4":
                    repeatGame = Gcd.startGame(sc, userName);
                    break;
                case "5":
                    repeatGame = Progression.startGame(sc, userName);
                    break;
                case "6":
                    repeatGame = Prime.startGame(sc, userName);
                    break;
                default:break;
            }
            if (repeatGame) {
                System.out.println("Correct!");
            }
            currentRound++;
        } while (repeatGame && currentRound < countRounds);
        if (countRounds == currentRound && repeatGame) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
