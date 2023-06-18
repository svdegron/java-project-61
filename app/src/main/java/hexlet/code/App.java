package hexlet.code;
import hexlet.code.games.Calc;
import hexlet.code.games.Eval;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Вывод меню
        printMenu();

        // Выбор игры
        String option = scanner.next();

        switch (option) {
            case "0" -> scanner.close();
            case "1" -> Cli.greeting();
            case "2" -> Eval.begin();
            case "3" -> Calc.begin();
            case "4" -> Gcd.begin();
            case "5" -> Progression.begin();
            case "6" -> Prime.begin();
            default -> throw new RuntimeException("Unknown option: " + option);
        }
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
}
