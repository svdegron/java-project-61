package hexlet.code;

//import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cli user;

        printMenu();

        int chooseItem = scanner.nextInt();

        switch (chooseItem) {
            case 1:
                createUser(scanner);
                break;
            case 2:
                user = createUser(scanner);
                Eval newGame = new Eval(user, scanner);
                newGame.startGame();
                break;
            default:
                System.out.println(String.format("Menu item with number \"%s\" is not in the list", chooseItem));
                break;
        }

        scanner.close();
    }

    public static void printMenu() {
        StringBuilder menu = new StringBuilder();

        menu.append("Please enter the game number and press Enter.\n");
        menu.append("1 - Greet\n");
        menu.append("2 - Even\n");
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
