package ru.rinat;

import java.io.File;

public class Utils {
    public static void validatePermissions(String permissions) throws IllegalArgumentException {
        if (permissions.length() != 3
                || !isValidChar(permissions.charAt(0))
                || !isValidChar(permissions.charAt(1))
                || !isValidChar(permissions.charAt(2))) {
            throw new IllegalArgumentException("Error: Invalid permissions");
        }
    }

    private static boolean isValidChar(char ch) {
        return ch == 'r' || ch == 'w' || ch == 'x' || ch == '-';
    }

    public static String readFile(File filePath) {
        try {
            return new String(java.nio.file.Files.readAllBytes(filePath.toPath()));
        } catch (Exception e) {
            return null;
        }
    }
}
