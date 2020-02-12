package homework.homework7;

import lombok.SneakyThrows;

public class NavalBattle {

    @SneakyThrows
    public void start() {

        try {
            while (true) {

                System.out.print("Select your opponent!\n" +
                        "Write 'bot' or 'player': ");

                String userChoice = ConsoleReader.reader.readLine();

                if (userChoice.equalsIgnoreCase("exit")) {
                    break;
                }

                selectPlayer(userChoice);
            }
        } finally {
            ConsoleReader.reader.close();
        }
    }

    private void selectPlayer(String userChoice) {

        if (userChoice.equalsIgnoreCase("bot")) {

        } else if (userChoice.equalsIgnoreCase("player")) {

        } else {
            System.out.printf("Unrecognized symbol '%s' Try again!\n", userChoice);
        }
    }

}
