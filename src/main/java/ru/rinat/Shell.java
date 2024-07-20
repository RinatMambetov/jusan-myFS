package ru.rinat;

import java.util.Scanner;

public class Shell {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        while (true) {
            String command = scanner.nextLine();
            String[] splitCommand = command.split(" ");
            if (!splitCommand[0].isBlank()) {
                if (splitCommand.length == 1) {
                    if (splitCommand[0].equals("exit")) {
                        return;
                    } else {
                        System.out.println("Wrong command, use help");
                    }
                } else if (splitCommand.length == 2) {
                    switch (splitCommand[0]) {
                        case "ls" -> MyFile.listDirectory(splitCommand[1]);
                        case "ls_py" -> MyFile.listPythonFiles(splitCommand[1]);
                        case "is_dir" -> MyFile.isDirectory(splitCommand[1]);
                        case "define" -> MyFile.define(splitCommand[1]);
                        case "readmod" -> MyFile.printPermissions(splitCommand[1]);
                        default -> System.out.println("Wrong command, use help");
                    }
                } else {
                    System.out.println("Wrong command, use help");
                }
            }
            System.out.print("> ");
        }
    }
}
