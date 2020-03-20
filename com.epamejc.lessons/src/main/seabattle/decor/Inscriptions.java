package main.seabattle.decor;

import static main.seabattle.decor.Colours.*;


public class Inscriptions {

    public static final String mainColour = GREEN;

    public static void printComputersField() {
        System.out.println(mainColour + "\uD835\uDC02\uD835\uDC28\uD835\uDC26\uD835\uDC29" +
                "\uD835\uDC2E\uD835\uDC2D\uD835\uDC1E\uD835\uDC2B\uD835\uDC2C❜ " +
                "\uD835\uDC1F\uD835\uDC22\uD835\uDC1E\uD835\uDC25\uD835\uDC1D:" + RESET);
    }

    public static void printMyField() {
        System.out.println(mainColour + "\uD835\uDC0C\uD835\uDC32 " +
                "\uD835\uDC1F\uD835\uDC22\uD835\uDC1E\uD835\uDC25\uD835\uDC1D:" + RESET);
    }

    public static void printEnterCoordinates() {
        System.out.print(mainColour + "\uD835\uDC04\uD835\uDC27\uD835\uDC2D\uD835\uDC1E\uD835\uDC2B " +
                "\uD835\uDC1C\uD835\uDC28\uD835\uDC28\uD835\uDC2B\uD835\uDC1D\uD835\uDC22\uD835" +
                "\uDC27\uD835\uDC1A\uD835\uDC2D\uD835\uDC1E\uD835\uDC2C: " + RESET);
    }

    public static void printWeAttack(int i, int j) {
        System.out.println(mainColour + "\uD835\uDC16\uD835\uDC1E \uD835\uDC1A\uD835\uDC2D\uD835" +
                "\uDC2D\uD835\uDC1A\uD835\uDC1C\uD835\uDC24: " + i + " " + j + RESET);
    }

    public static void printRandomlyOrManually() {
        System.out.print(mainColour + "\uD835\uDC00\uD835\uDC2B\uD835\uDC2B\uD835\uDC1A\uD835" +
                "\uDC27\uD835\uDC20\uD835\uDC1E \uD835\uDC2D\uD835\uDC21\uD835\uDC1E \uD835\uDC2C" +
                "\uD835\uDC21\uD835\uDC22\uD835\uDC29\uD835\uDC2C \uD835\uDC2B\uD835\uDC1A\uD835" +
                "\uDC27\uD835\uDC1D\uD835\uDC28\uD835\uDC26\uD835\uDC25\uD835\uDC32(\uD835\uDFCF) " +
                "\uD835\uDC28\uD835\uDC2B \uD835\uDC26\uD835\uDC1A\uD835\uDC27\uD835\uDC2E\uD835" +
                "\uDC1A\uD835\uDC25\uD835\uDC25\uD835\uDC32(\uD835\uDFCE): " + RESET);
    }

    public static void printYouWon() {
        System.out.println(CYAN);
        System.out.println(
                "╔╗╔╗ ╔══╗ ╔╗╔╗   ╔╗╔╗╔╗ ╔══╗ ╔╗ ╔╗" + "\n" +
                        "║║║║ ║╔╗║ ║║║║   ║║║║║║ ║╔╗║ ║╚═╝║" + "\n" +
                        "║╚╝║ ║║║║ ║║║║   ║║║║║║ ║║║║ ║╔╗ ║" + "\n" +
                        "╚═╗║ ║║║║ ║║║║   ║║║║║║ ║║║║ ║║╚╗║" + "\n" +
                        " ╔╝║ ║╚╝║ ║╚╝║   ║╚╝╚╝║ ║╚╝║ ║║ ║║" + "\n" +
                        " ╚═╝ ╚══╝ ╚══╝   ╚═╝╚═╝ ╚══╝ ╚╝ ╚╝"
        );
    }

    public static void printYouLose() {
        System.out.println(RED);
        System.out.println(
                "╔╗╔╗ ╔══╗ ╔╗╔╗   ╔╗   ╔══╗ ╔══╗ ╔═══╗" + "\n" +
                        "║║║║ ║╔╗║ ║║║║   ║║   ║╔╗║ ║╔═╝ ║╔══╝" + "\n" +
                        "║╚╝║ ║║║║ ║║║║   ║║   ║║║║ ║╚═╗ ║╚══╗" + "\n" +
                        "╚═╗║ ║║║║ ║║║║   ║║   ║║║║ ╚═╗║ ║╔══╝" + "\n" +
                        " ╔╝║ ║╚╝║ ║╚╝║   ║╚═╗ ║╚╝║ ╔═╝║ ║╚══╗" + "\n" +
                        " ╚═╝ ╚══╝ ╚══╝   ╚══╝ ╚══╝ ╚══╝ ╚═══╝"
        );
    }

}
