package ru.rinat;

import java.util.Scanner;

public class Shell {
    public static void run(){
        Scanner scanner= new Scanner(System.in);
        System.out.print("> ");
        while(true){
            String command = scanner.nextLine();
            String[] splitCommand = command.split(" ");
            if(splitCommand[0].equals("exit")){
                return;
            }else if (splitCommand[0].equals("ls")){
                MyFile.listDirectory(splitCommand[1]);
            }
            System.out.print("> ");
        }
    }
}
