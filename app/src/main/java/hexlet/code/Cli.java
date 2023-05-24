package hexlet.code;

public class Cli {
    private String name;

    Cli(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void greeting() {
        System.out.print("May I have your name? ");
    }
}
