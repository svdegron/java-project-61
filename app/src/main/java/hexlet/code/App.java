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
        String gameNumber = scanner.next();

        // Обработка ввода 0, 1 и точка входа в игры
        switch (gameNumber) {
            case "0":
                // Выход
                break;
            // Приветствие
            case "1":
                Cli.greeting();
                break;
            // Игры
            case "2":
                Eval.begin();
                break;
            case "3":
                Calc.begin();
                break;
            case "4":
                Gcd.begin();
                break;
            case "5":
                Progression.begin();
                break;
            case "6":
                Prime.begin();
                break;
            default:
                // по умолчанию - выход
                break;
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
}
