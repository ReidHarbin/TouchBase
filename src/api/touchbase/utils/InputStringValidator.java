package api.touchbase.utils;

import java.util.regex.Pattern;

public class InputStringValidator {
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile("[a-z]");
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile("[A-Z]");
    private static final Pattern NUMBER_CHARACTER_PATTERN = Pattern.compile("[0-9]");
    private static final Pattern SPACE_CHARACTER_PATTERN = Pattern.compile("\\s");

    public static boolean isValidPassword(final String passwordToValidate) {
        return (
                (passwordToValidate != null &&
                 !passwordToValidate.isBlank() &&
                 passwordToValidate.length() >= 8) &&
                 !SPACE_CHARACTER_PATTERN.matcher(passwordToValidate).find() &&
                (LOWERCASE_PATTERN.matcher(passwordToValidate).find() &&
                 UPPERCASE_PATTERN.matcher(passwordToValidate).find() &&
                 NUMBER_CHARACTER_PATTERN.matcher(passwordToValidate).find())
        );
    }
}
