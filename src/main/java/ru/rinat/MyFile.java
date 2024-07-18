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
            System.out.print("Directory does not exist");
        }
        System.out.println();
    }
}
