package hexlet.code;

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
}
