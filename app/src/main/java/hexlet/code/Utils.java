package hexlet.code;

import java.util.Random;

public class Utils {
    public static int randomNum() {
        return randomNum(Engine.MIN_NUMBER, Engine.MAX_NUMBER);
    }

    public static int randomNum(int max) {
        return randomNum(Engine.MIN_NUMBER, max);
    }

    public static int randomNum(int min, int max) {
        return new Random().nextInt(min, max);
    }
}
