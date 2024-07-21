package ru.rinat;

import java.util.Arrays;
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
                if (Command.contains(splitCommand[0])) {
                    Command cmd = Command.valueOf(splitCommand[0].toUpperCase());
                    switch (cmd) {
                        case EXIT, PRINTPATH, HELP -> handleOneWordCommands(cmd.name().toLowerCase());
                        case LS, LS_PY, IS_DIR, DEFINE, READMOD, CAT, APPEND, BC, GREPLONG -> {
                            if (splitCommand.length == 2) {
                                try {
                                    handleTwoWordCommands(cmd.name().toLowerCase(), splitCommand[1]);
                                } catch (MyException e) {
                                    System.out.println(e.getMessage());
                                }
                            } else {
                                System.out.println("Error: Wrong command " + cmd.name().toLowerCase() + ", use help");
                            }
                        }
                        case SETMOD -> {
                            if (splitCommand.length == 3) {
                                try {
                                    handleThreeWordCommands(cmd.name().toLowerCase(), splitCommand[1], splitCommand[2]);
                                } catch (MyException e) {
                                    System.out.println(e.getMessage());
                                }
                            } else {
                                System.out.println("Error: Wrong command " + cmd.name().toLowerCase() + ", use help");
                            }
                        }
                    }
                } else {
                    System.out.println("Error: Wrong command " + splitCommand[0] + ", use help");
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

    private enum Command {
        EXIT, PRINTPATH, HELP, LS, LS_PY, IS_DIR, DEFINE, READMOD, CAT, APPEND, BC, GREPLONG, SETMOD;

        public static boolean contains(String cmd) {
            return Arrays.stream(values()).anyMatch(v -> v.name().equalsIgnoreCase(cmd));
        }
    }
}
