package homeworks.java.seabattle;

import homeworks.java.seabattle.battle.Battle;
import homeworks.java.seabattle.field.Field;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        Battle battle = new Battle();
        battle.startBattle(buffer);

    }
}
