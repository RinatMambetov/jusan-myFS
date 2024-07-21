package ru.rinat;

import java.util.Scanner;

public class Shell {
    public static void run() {
        MyFile.help();
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        while (true) {
            String command = scanner.nextLine();
            String[] splitCommand = command.split(" ");
            if (!splitCommand[0].isBlank()) {

                if (splitCommand.length == 1) {
                    switch (splitCommand[0]) {
                        case "exit", "printpath", "help" -> {
                            handleOneWordCommands(splitCommand[0]);
                        }
                        default -> System.out.println("Wrong command, use help");
                    }
                } else if (splitCommand.length == 2) {
                    switch (splitCommand[0]) {
                        case "ls", "ls_py", "is_dir", "define", "readmod", "cat", "append", "bc", "greplong" -> {
                            try {
                                handleTwoWordCommands(splitCommand[0], splitCommand[1]);
                            } catch (MyException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        default -> System.out.println("Wrong command, use help");
                    }
                } else if (splitCommand.length == 3) {
                    switch (splitCommand[0]) {
                        case "setmod" -> {
                            try {
                                handleThreeWordCommands(splitCommand[0], splitCommand[1], splitCommand[2]);
                            } catch (MyException e) {
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

    private static void handleOneWordCommands(String command) {
        switch (command) {
            case "exit" -> {
                System.out.println("Goodbye");
                System.exit(0);
            }
            case "printpath" -> MyFile.printPath();
            case "help" -> MyFile.help();
        }
    }

    private static void handleTwoWordCommands(String command, String argument) throws MyException {
        switch (command) {
            case "ls" -> MyFile.listDirectory(argument);
            case "ls_py" -> MyFile.listPythonFiles(argument);
            case "is_dir" -> MyFile.isDirectory(argument);
            case "define" -> MyFile.define(argument);
            case "readmod" -> MyFile.printPermissions(argument);
            case "cat" -> MyFile.printContent(argument);
            case "append" -> MyFile.appendFooter(argument);
            case "bc" -> MyFile.createBackup(argument);
            case "greplong" -> MyFile.printLongestWord(argument);
        }
    }

    private static void handleThreeWordCommands(String command, String argument1, String argument2) throws MyException {
        switch (command) {
            case "setmod" -> MyFile.setPermissions(argument1, argument2);
        }
    }
}
