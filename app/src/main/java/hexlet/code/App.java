package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Eval;
import hexlet.code.games.Game;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cli user;

        printMenu();

        String chooseItem = scanner.next();

        Game game = null;

        switch (chooseItem) {
            case "1":
                createUser(scanner);
                break;
            case "2":
                user = createUser(scanner);
                game = new Eval(user, scanner);
                break;
            case "3":
                user = createUser(scanner);
                game = new Calc(user, scanner);
                break;
            case "4":
                user = createUser(scanner);
                game = new Gcd(user, scanner);
                break;
            case "5":
                user = createUser(scanner);
                game = new Progression(user, scanner);
                break;
            case "6":
                user = createUser(scanner);
                game = new Prime(user, scanner);
                break;
            default:
                System.out.println(String.format("Menu item with number \"%s\" is not in the list", chooseItem));
                break;
        }

        if (game != null) {
            Engine.startGame(game);
        }

        scanner.close();
    }

    public static void printMenu() {
        StringBuilder menu = new StringBuilder();

        menu.append("Please enter the game number and press Enter.\n");
        menu.append("1 - Greet\n");
        menu.append("2 - Even\n");
        menu.append("3 - Calc\n");
        menu.append("4 - GCD\n");
        menu.append("5 - Progression\n");
        menu.append("6 - Prime\n");
        menu.append("0 - Exit\n");
        menu.append("Your choice: ");

        System.out.print(menu.toString());
    }

    public static Cli createUser(Scanner scanner) {
        Cli.greeting();

        String userName = scanner.next();

        Cli user = new Cli(userName);

        System.out.println(String.format("Hello, %s!", user.getName()));

        return user;
    }
}
