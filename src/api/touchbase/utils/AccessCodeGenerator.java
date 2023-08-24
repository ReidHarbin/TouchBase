package api.touchbase.utils;

import java.util.Random;

public class AccessCodeGenerator {
    public static String generateAccessCode() {
        return String.valueOf(new Random(System.currentTimeMillis()).nextInt(99999999));
    }
}
