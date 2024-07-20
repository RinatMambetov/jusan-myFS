package ru.rinat;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class MyFile {
    public static void listDirectory(String path) {
        File directoryPath = new File(path);
        if (directoryPath.exists() && directoryPath.isDirectory()) {
            Arrays.stream(Objects.requireNonNull(directoryPath.listFiles()))
                    .map(elem -> elem.getName() + " ").forEach(System.out::print);
        } else {
            System.out.print("Wrong path");
        }
        System.out.println();
    }

    public static void listPythonFiles(String path) {
        File directoryPath = new File(path);
        if (directoryPath.exists() && directoryPath.isDirectory()) {
            Arrays.stream(Objects.requireNonNull(directoryPath.listFiles()))
                    .filter(elem -> elem.getName().endsWith(".py"))
                    .map(elem -> elem.getName() + " ").forEach(System.out::print);
        } else {
            System.out.print("Wrong path");
        }
        System.out.println();
    }

    public static void isDirectory(String path) {
        File directoryPath = new File(path);
        if (directoryPath.exists()) {
            if (directoryPath.isDirectory()) {
                System.out.println("true");
            } else if (directoryPath.isFile()) {
                System.out.println("false");
            }
        } else {
            System.out.println("Wrong path");
        }
    }

    public static void define(String path) {
        File directoryPath = new File(path);
        if (directoryPath.exists()) {
            if (directoryPath.isDirectory()) {
                System.out.println("directory");
            } else if (directoryPath.isFile()) {
                System.out.println("file");
            }
        } else {
            System.out.println("Wrong path");
        }
    }

    public static void printPermissions(String path) {
        File directoryPath = new File(path);
        if (directoryPath.exists()) {
            boolean canRead = directoryPath.canRead();
            boolean canWrite = directoryPath.canWrite();
            boolean canExecute = directoryPath.canExecute();
            if (canRead) {
                System.out.print("r");
            } else {
                System.out.print("-");
            }
            if (canWrite) {
                System.out.print("w");
            } else {
                System.out.print("-");
            }
            if (canExecute) {
                System.out.print("x");
            } else {
                System.out.print("-");
            }
            System.out.println();
        } else {
            System.out.println("Wrong path");
        }
    }
}
