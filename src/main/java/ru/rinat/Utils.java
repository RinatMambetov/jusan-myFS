package ru.rinat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public static String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(new Date());
    }

    public static void copyDirectory(File directoryPath, File backupDirectory) {
        try {
            Path sourceDirPath = directoryPath.toPath();
            Path backupDirPath = backupDirectory.toPath();

            Files.walk(sourceDirPath)
                    .forEach(sourcePath -> {
                        Path relativePath = sourceDirPath.relativize(sourcePath);
                        Path targetPath = backupDirPath.resolve(relativePath);
                        try {
                            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            System.err.println("Error: Failed to copy " + sourcePath + ": " + e.getMessage());
                        }
                    });
        } catch (IOException e) {
            System.err.println("Error: Failed to copy directory: " + e.getMessage());
        }
    }

    public static void copyFile(File filePath, File backupDirectory) {
        try {
            Path sourceFilePath = filePath.toPath();
            Path backupDirPath = backupDirectory.toPath();
            Path targetFilePath = backupDirPath.resolve(filePath.getName());
            Files.copy(sourceFilePath, targetFilePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Error: Failed to copy file: " + e.getMessage());
        }
    }
}
