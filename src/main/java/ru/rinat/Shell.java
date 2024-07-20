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
                        case "ls", "ls_py", "is_dir", "define", "readmod" -> {
                            try {
                                handleTwoWordCommands(splitCommand[0], splitCommand[1]);
                            } catch (WrongPathException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        default -> System.out.println("Wrong command, use help");
                    }
                } else {
                    System.out.println("Wrong command, use help");
                }
            }
            System.out.print("> ");
        }
    }

    private static void handleTwoWordCommands(String command, String argument) throws WrongPathException {
        switch (command) {
            case "ls" -> MyFile.listDirectory(argument);
            case "ls_py" -> MyFile.listPythonFiles(argument);
            case "is_dir" -> MyFile.isDirectory(argument);
            case "define" -> MyFile.define(argument);
            case "readmod" -> MyFile.printPermissions(argument);
        }
    }
}
