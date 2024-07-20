package ru.rinat;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class MyFile {

    public static void listDirectory(String path) throws MyException {
        File directoryPath = new File(path);
        if (directoryPath.exists() && directoryPath.isDirectory()) {
            Arrays.stream(Objects.requireNonNull(directoryPath.listFiles()))
                    .map(elem -> elem.getName() + " ").forEach(System.out::print);
        } else {
            throw new MyException("Error: Wrong path");
        }
        System.out.println();
    }

    public static void listPythonFiles(String path) throws MyException {
        File directoryPath = new File(path);
        if (directoryPath.exists() && directoryPath.isDirectory()) {
            Arrays.stream(Objects.requireNonNull(directoryPath.listFiles()))
                    .filter(elem -> elem.getName().endsWith(".py"))
                    .map(elem -> elem.getName() + " ").forEach(System.out::print);
        } else {
            throw new MyException("Error: Wrong path");
        }
        System.out.println();
    }

    public static void isDirectory(String path) throws MyException {
        File directoryPath = new File(path);
        if (directoryPath.exists()) {
            if (directoryPath.isDirectory()) {
                System.out.println("true");
            } else if (directoryPath.isFile()) {
                System.out.println("false");
            }
        } else {
            throw new MyException("Error: Wrong path");
        }
    }

    public static void define(String path) throws MyException {
        File directoryPath = new File(path);
        if (directoryPath.exists()) {
            if (directoryPath.isDirectory()) {
                System.out.println("directory");
            } else if (directoryPath.isFile()) {
                System.out.println("file");
            }
        } else {
            throw new MyException("Error: Wrong path");
        }
    }

    public static void printPermissions(String path) throws MyException {
        File directoryPath = new File(path);
        if (directoryPath.exists()) {
            System.out.print(directoryPath.canRead() ? "r" : "-");
            System.out.print(directoryPath.canWrite() ? "w" : "-");
            System.out.print(directoryPath.canExecute() ? "x" : "-");
            System.out.println();
        } else {
            throw new MyException("Error: Wrong path");
        }
    }

    public static void setPermissions(String path, String permissions) throws MyException {
        try {
            Utils.validatePermissions(permissions);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        File directoryPath = new File(path);
        if (directoryPath.exists()) {
            directoryPath.setReadable(permissions.charAt(0) == 'r');
            directoryPath.setWritable(permissions.charAt(1) == 'w');
            directoryPath.setExecutable(permissions.charAt(2) == 'x');
        } else {
            throw new MyException("Error: Wrong path");
        }
    }

    public static void printContent(String path) throws MyException {
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            String content = Utils.readFile(file);
            if (content != null) {
                System.out.println(content);
            }
        } else {
            throw new MyException("Error: Wrong path");
        }
    }
}
