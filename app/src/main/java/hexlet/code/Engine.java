package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Eval;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class Engine {

    public static void chooseGame(Scanner sc) {
        String gameNumber = sc.next();
        String exit = "0";
        if (!gameNumber.equals(exit)) {
            String userName = Cli.greeting(sc);
            final int countRounds = 3;
            int currentRound = 0;
            boolean repeatGame = false;
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
}
