package homeworks.sea_battle.logic;

import homeworks.sea_battle.commands.ShipsSetterCommands;
import homeworks.sea_battle.data.Coordinates;
import homeworks.sea_battle.data.Player;
import homeworks.sea_battle.enums.Points;
import homeworks.sea_battle.enums.SystemMessages;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IOOperations {

    private Scanner scanner;

    public IOOperations() {
        this.scanner = new Scanner(System.in);
    }

    public int parseGameSettingsInput() {
        while (true) {
            System.out.println(SystemMessages.CHOOSE_GAME_MODE.message);

            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Wrong entry! You should enter a number from menu");
            }
        }
    }

    public String enterPlayerName() {
        while (true) {
            System.out.print(SystemMessages.PLAYER_NAME.message);
            try {
                return scanner.nextLine();
            } catch (Exception e) {
                System.err.println("You should enter correct name!");
            }
        }
    }

    public Coordinates parseCoordinates() {
        Coordinates coordinates = null;

        while (true) {
            try {
                String input = scanner.nextLine();

                if (input.toLowerCase().equals("exit")) {
                    scanner.close();
                    System.exit(0);
                    break;
                }

                if (checkUserInputForMatches(input)) {
                    String letter = input.substring(0, 1).toUpperCase();
                    int x = Points.valueOf(letter).ordinal();
                    int y = Integer.parseInt(input.substring(1)) - 1;
                    coordinates = new Coordinates(x, y);
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Wrong Entry! Type coordinates! (example: a1)");
            }
        }

        return coordinates;
    }

    public boolean parseDirection(Coordinates coordinates, int decksQty) {

        while (true) {
            System.out.print(SystemMessages.SET_DIRECTION.message);
            try {
                String input = scanner.nextLine();

                switch (input.toLowerCase()) {
                    case ("up") : {
                        if (coordinates.getY() - (decksQty - 1) < 0) {
                            return false;
                        }
                        coordinates.setY(coordinates.getY() - (decksQty - 1));
                        return false;
                    }
                    case ("down") : {
                        return false;
                    }
                    case ("left") : {
                        if (coordinates.getX() - (decksQty - 1) < 0) {
                            return true;
                        }
                        coordinates.setX(coordinates.getX() - (decksQty - 1));
                        return true;
                    }
                    case ("right") : {
                        return true;
                    }
                    default: {
                        throw new Exception();
                    }
                }
            } catch (Exception e) {
                System.err.println("Wrong entry! Type direction!");
            }
        }
    }

    public ShipsSetterCommands chooseShipSetter(Player player, IOOperations ioOperations) {
        ShipsSetterCommands shipsSetterCommands = new AutomaticShipSetter();

        boolean isBot = player.getName().equals("Bot Player");

        while (!isBot) {
            System.out.print(player.getName() + " ");
            System.out.print(SystemMessages.CHOOSE_SHIP_SETTER.message);
            try {
                String input = scanner.nextLine();
                if (input.toUpperCase().equals("Y")) {
                    shipsSetterCommands = new ManualShipsSetter(ioOperations);
                    break;
                } else if (input.toUpperCase().equals("N")) {
                    shipsSetterCommands = new AutomaticShipSetter();
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Wrong entry! Type Y or N!");
            }
        }

        return shipsSetterCommands;
    }

    public void close() {
        scanner.close();
    }

    private boolean checkUserInputForMatches(String userInput) {
        String REGEX = "^(\\w{1}\\d{1,})";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(userInput);

        return matcher.matches();
    }

}
