package homeworks.java.seabattle.input;

import java.io.BufferedReader;

import static homeworks.java.seabattle.input.Orientation.*;

public class Input implements InputListener{

    public void process(String line, boolean cond){

        String[] shipInfo = line.split(", ");

        int x = -1;
        int y = -1;
        int decksNumber = -1;
        Orientation orient = NONE; //ориентация корабля

        if(!cond && shipInfo.length >= 2){
            x = Character.toLowerCase(shipInfo[0].charAt(0)) - 'a'; //получаем число от 0 до 9,
            // которое будет указывать координату по горизонтали
            y = Integer.parseInt(shipInfo[1]); //координата по вертикали
            decksNumber = Integer.parseInt(shipInfo[2]); // количество палуб

            if(shipInfo[3] != null && shipInfo[3].equalsIgnoreCase("h")){
                orient = HORIZONTAL;
            } else if(shipInfo[3] != null && shipInfo[3].equalsIgnoreCase("v")){
                orient = VERTICAL;
            }
        }
    }

    @Override
    public void makeship(int x, int y, int decksNumber, Orientation o) {

    }

}
