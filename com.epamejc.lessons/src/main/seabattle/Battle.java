package main.seabattle;

import main.seabattle.fields.CustomField;
import main.seabattle.fields.HiddenField;
import main.seabattle.fields.VisibleField;

import java.util.Scanner;

import static main.seabattle.decor.Inscriptions.*;


public class Battle {

    private Scanner scanner;
    private CustomField myField;
    private Gan gan;
    private VisibleField VisibleComputerField;
    private HiddenField hiddenComputerField;
    private int countHitsMe;
    private int countHitsComputer;

    public Battle() {
        scanner = new Scanner(System.in);
        myField = new CustomField();
        gan = new Gan();
        VisibleComputerField = new VisibleField();
        hiddenComputerField = new HiddenField();
    }

    public void setup() {
        customPreparation();
        computerPreparation();
        goBattle();
    }

    public void customPreparation() {
        printRandomlyOrManually();
        int random = scanner.nextInt();
        if (random == 1) {
            myField.createShipsAutomatic();
            myField.printField("custom");
        } else {
            myField.createShipsManually();
        }
    }

    public void computerPreparation() {
        hiddenComputerField.createShipsAutomatic();
        VisibleComputerField.printField("computer");
    }

    public void goBattle() {
        boolean myMoves;
        boolean computerMoves;
        do {
            myMoves = myMove();
            if (!myMoves) {
                break;
            }
            computerMoves = computerMove();
        } while (computerMoves);
    }

    public boolean myMove() {
        boolean hit;
        do {
            printEnterCoordinates();
            int i = scanner.nextInt();
            if (i == -1) {
                return false;
            }
            int j = scanner.nextInt();
            hit = hiddenComputerField.attack(i, j);
            if (hit) {
                countHitsMe++;
            }
            VisibleComputerField.attackClear(i, j, hit);
            VisibleComputerField.printField("computer");
            if (countHitsMe == 20) {
                printYouWon();
                return false;
            }
        } while (hit);
        return true;
    }

    public boolean computerMove() {
        boolean hit;
        do {
            int attack = gan.takeAttack();
            if (attack == -1) {
                return false;
            }
            int i = attack % 10;
            int j = attack / 10;
            printWeAttack(i, j);
            hit = myField.attack(i, j);
            myField.printField("custom");
            if (hit) {
                countHitsComputer++;
            }
            if (countHitsComputer == 20) {
                printYouLose();
                return false;
            }
        } while (hit);
        return true;
    }

}
