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
                    if (splitCommand[0].equals("ls")) {
                        MyFile.listDirectory(splitCommand[1]);
                    } else {
                        System.out.println("Wrong command, use help");
                    }
                } else {
                    System.out.println("Wrong command, use help");
                }
            }
            System.out.print("> ");
        }
    }
}
