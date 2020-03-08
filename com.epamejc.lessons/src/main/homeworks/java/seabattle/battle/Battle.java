package homeworks.java.seabattle.battle;

import homeworks.java.seabattle.field.Field;

import java.io.BufferedReader;
import java.io.IOException;

public class Battle {

    public void startBattle(BufferedReader buffer){

        boolean cond = true;

        while (cond){

            System.out.println("---- Players field ----");
            Field playersField = new Field();

            System.out.println("---- Enemies field ----");
            Field enemiesField = new Field();

            String line = null;

            try{
                line = buffer.readLine();
            } catch (IOException ex){
                ex.printStackTrace();
            }

            if(line.equalsIgnoreCase("exit")){
                cond = false;
                continue;
            }


            //еще какой-то метод для обработки расстановки кораблей
        }

        try{
            buffer.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
