package ru.chernitsyna.tm;

import java.util.Scanner;

import static ru.chernitsyna.tm.constant.TerminalConst.*;

public class App {

    public static void main(final String[] args) {
        displayWelcome();
        run(args);
        final Scanner scanner = new Scanner(System.in);
        String command = "";
        while (!EXIT.equals(command)) {
            command = scanner.nextLine();
            run(command);
        }
    }

    private static int displayError() {
        System.out.println("Error! Unknown argument...");
        return -1;
    }

    private static void displayWelcome() {
        System.out.println("** WELCOME TO TASK MANAGER **");
    }

    private static void run(final String[] args) {
        if (args == null) return;
        if (args.length < 1) return;
        final String param = args[0];
        final int result = run(param);
        System.exit(result);
    }

    private static int run(final String param) {
        if (param == null) return -1;
        switch (param) {
            case HELP:
                return displayHelp();
            case VERSION:
                return displayVersion();
            case ABOUT:
                return displayAbout();
            case EXIT:
                return displayExit();
            default:
                return displayError();
        }
    }

    private static int displayExit() {
        System.out.println("Terminate program...");
        return 0;
    }

    private static int displayAbout() {
        System.out.println("Yuliya Chernitsyna");
        System.out.println("chernitsyna_ys@nmk.com");
        return 0;
    }

    private static int displayVersion() {
        System.out.println("1.0.0");
        return 0;
    }

    private static int displayHelp() {
        System.out.println("version - Display program version");
        System.out.println("about - Display developer info");
        System.out.println("help - Display list of terminal commands");
        System.out.println("exit - Terminate console application");
        return 0;
    }

}
