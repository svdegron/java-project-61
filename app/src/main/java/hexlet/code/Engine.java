package hexlet.code;

import hexlet.code.games.Game;

public class Engine {

    public static void startGame(Game game) {
        game.printDescription();

        final int numberRounds = 3;
        int currentRound = 0;

        boolean repeatGame = false;

        do {
            repeatGame = game.launch();

            if (repeatGame) {
                System.out.println("Correct!");
            } else {
                game.printError();
            }

            currentRound++;
        } while (repeatGame && currentRound < numberRounds);

        if (numberRounds == currentRound && repeatGame) {
            System.out.println("Congratulations, " + game.getPlayerName() + "!");
        }
    }
}
