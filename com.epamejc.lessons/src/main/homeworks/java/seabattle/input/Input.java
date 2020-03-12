package homeworks.java.seabattle.input;

import homeworks.java.seabattle.field.Coordinatepointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static homeworks.java.seabattle.input.Orientation.*;

public class Input {

    private BufferedReader buffer;
    private InputListener inListener;
    private int currentShipDeckNumber;
    private final String baseFillingMessage = "Input %d-deck ship in format %s";
    private String currentMessage;
    private String line;

    public Input(){

        buffer = new BufferedReader(new InputStreamReader(System.in));
//        inListener = listener;
        currentShipDeckNumber = 1;

        showNewMessage();
    }

    private void showNewMessage() {
        String format = currentShipDeckNumber > 1 ? "x, y, orientation" : "x, y";
        currentMessage = String.format(baseFillingMessage, currentShipDeckNumber, format);
    }

    public void process(GameState state) {
        System.out.println(currentMessage);
        line = null;

        try {
            line = buffer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean exitDone = line.equalsIgnoreCase("exit");

        if (exitDone) {
            inListener.exitGame();
            return;
        }

        if (state == GameState.SETUP) {
            fillField(line);
        } else if (state == GameState.BATTLE) {
            doBattle(line);
        }
    }

    public Coordinatepointer parseCoordinates(String inLine) {
        String[] coordinates = inLine.split(",");
        int x = -1;
        int y = -1;

        if (coordinates.length == 2) {
            x = Character.toLowerCase(coordinates[0].charAt(0)) - 'a';
            y = Integer.parseInt(coordinates[1]);
        }

        return new Coordinatepointer(x, y);
    }

    private void fillField(String line) {

        String[] shipInfo = line.split(";");

        Orientation orient = NONE; //ориентация корабля

        if (shipInfo.length == 1 && line.equalsIgnoreCase("auto fill")) {
            inListener.fillAutomatically();
        }

        if (shipInfo.length > 1) {
            Coordinatepointer coordinate = parseCoordinates(line);

            if(currentShipDeckNumber == 1) {
                orient = DEFAULT;
            }else if (shipInfo[1] != null && shipInfo[1].equalsIgnoreCase("h")) {
                orient = HORIZONTAL;
            } else if (shipInfo[1] != null && shipInfo[1].equalsIgnoreCase("v")) {
                orient = VERTICAL;
            } else {
                orient = NONE;
            }

            if(orient != NONE && coordinate.x >= 0 && coordinate.y >= 0){
                if(!inListener.makeShip(currentShipDeckNumber, orient,
                        new Coordinatepointer(coordinate.x, coordinate.y))) {
                    currentShipDeckNumber++;
                    showNewMessage();
                }
            }
        }
    }

    private void doBattle(String line) {
        Coordinatepointer coordinate = parseCoordinates(line);

        if(coordinate.x >= 0 && coordinate.y >= 0){
            inListener.attack(coordinate.x, coordinate.y);
        }
    }

    public void closeBuffer(){
        try {
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
