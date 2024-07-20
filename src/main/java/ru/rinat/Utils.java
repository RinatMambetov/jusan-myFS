package ru.rinat;

public class Utils {
    public static void validatePermissions(String permissions) throws IllegalArgumentException {
        if (permissions.length() != 3
                || !isValidChar(permissions.charAt(0))
                || !isValidChar(permissions.charAt(1))
                || !isValidChar(permissions.charAt(2))) {
            throw new IllegalArgumentException("Invalid permissions");
        }
    }

    private static boolean isValidChar(char ch) {
        return ch == 'r' || ch == 'w' || ch == 'x' || ch == '-';
    }
}
