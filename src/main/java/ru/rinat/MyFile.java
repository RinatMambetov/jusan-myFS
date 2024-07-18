package ru.rinat;

import java.io.File;

public class MyFile {
    // выводит список всех файлов и директорий для `path` - ls
    public static void listDirectory(String path) {
        File directoryPath= new File(path);
        for(File elem: directoryPath.listFiles()){
            System.out.print(elem.getName()+" ");
        }
        System.out.println();
    }
}
