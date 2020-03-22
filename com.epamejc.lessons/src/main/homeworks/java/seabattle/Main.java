package main.homeworks.java.seabattle;

import main.homeworks.java.seabattle.controller.Game;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        new Game().start(new Scanner(System.in));
    }
}
