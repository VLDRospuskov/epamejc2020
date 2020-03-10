package seabattle.Menus;

import lombok.SneakyThrows;
import seabattle.FieldDrawer;
import seabattle.Players.Player;
import seabattle.ShipPlacingParams;

public class MenuShipPlacer extends Menu {

    @SneakyThrows
    public String readShipPlacement(int numberOfDecks) {
        System.out.print("Place " + numberOfDecks + "-deck ship: ");
        return reader.readLine();
    }

    @Override
    public void printMenu() {
        System.out.println("Enter coordinates and direction for each ship. For example: \"a2 right\"");
    }

    @Override
    public void executeCommand(String command) {
    }

    @Override
    public void run() {
    }

    public void runForPlayer(Player player) {
        printMenu();

        player.getShipsCounter().shipMap.forEach((decks, numberOfShips) -> {
            for (int i = 0; i < numberOfShips; i++) {
                FieldDrawer.printMenu(player.getMainField());
                ShipPlacingParams shipPlacingParams;
                do {
                    String shipPlacement = readShipPlacement(decks);
                    shipPlacingParams = new ShipPlacingParams(shipPlacement, decks);
                    System.out.println(player.getMainField().isShipPlacementLegal(shipPlacingParams) ?
                            "Ship placed successfully" :
                            "Ship can't be placed here");
                } while (!player.getMainField().isShipPlacementLegal(shipPlacingParams));
                player.getMainField().placeShip(shipPlacingParams);
            }
        });
        System.out.println("All ships are placed. Get ready to battle!");
    }

}
