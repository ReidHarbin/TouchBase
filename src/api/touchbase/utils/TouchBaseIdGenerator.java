package api.touchbase.utils;

import java.util.Random;
import java.util.UUID;

public class TouchBaseIdGenerator {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
