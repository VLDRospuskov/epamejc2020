package seabattle.menus;

import lombok.SneakyThrows;

public class MenuMain extends Menu {

    @SneakyThrows
    public void run() {
        String command;
        do {
            printMenu();
            System.out.print("Enter command: ");
            command = readCommand();
            executeCommand(command);
        } while (!command.equals("0") && !command.equals("exit"));
    }

    @Override
    public void printMenu() {
        System.out.println("1. Start game");
        System.out.println("0. Exit");
    }

    @Override
    public void executeCommand(String command) {
        int commandKey = 0;
        try {
            commandKey = Integer.parseInt(command);
        } catch (NumberFormatException e) {
            System.out.println("Wrong command!");
        }

        switch (commandKey) {
            case 1:
                game.startGame();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;
        }

    }


}
