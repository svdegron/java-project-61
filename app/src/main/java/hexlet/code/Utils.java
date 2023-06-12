package hexlet.code;

import java.util.Random;

public class Utils {
    public static int randomNum() {
        Random generate = new Random();
        return generate.nextInt(Engine.MIN_NUMBER, Engine.MAX_NUMBER);
    }

    public static int randomNum(int max) {
        Random generate = new Random();
        return generate.nextInt(max);
    }

    public static int randomNum(int min, int max) {
        Random generate = new Random();
        return generate.nextInt(max);
    }
}
