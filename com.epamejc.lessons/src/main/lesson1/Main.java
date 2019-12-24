package main.lesson1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static final String ANSI_BLACK = "\u001B[30m";


    public static final String[] FOREGROUNDS = {
            ANSI_BLACK
    };

    public static final String ANSI_BRIGHT_BG_RED = "\u001B[101m";
    public static final String ANSI_BRIGHT_BG_GREEN = "\u001B[102m";
    public static final String ANSI_BRIGHT_BG_YELLOW = "\u001B[103m";


    public static final String[] BACKGROUNDS1 = {
            ANSI_BRIGHT_BG_GREEN};
    public static final String[] BACKGROUNDS2 = {
            ANSI_BRIGHT_BG_YELLOW};
    public static final String[] BACKGROUNDS3 = {
            ANSI_BRIGHT_BG_RED};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the time : ");
        String time = reader.readLine();
        int CurrentTimeInt = Integer.parseInt(time);

        switch (CurrentTimeInt) {
            case 0:
                for (String fg : FOREGROUNDS) {
                    for (String bg : BACKGROUNDS1)
                        System.out.print(fg + bg + "It's the green time! ");
                }
                break;
            case 1:
                for (String fg : FOREGROUNDS) {
                    for (String bg : BACKGROUNDS1)
                        System.out.print(fg + bg + "It's the green time! ");
                }
                break;
            case 2:
                for (String fg : FOREGROUNDS) {
                    for (String bg : BACKGROUNDS1)
                        System.out.print(fg + bg + "It's the green time! ");
                }
                break;
            case 3:
                for (String fg : FOREGROUNDS) {
                    for (String bg : BACKGROUNDS1)
                        System.out.print(fg + bg + "It's the green time! ");
                }
                break;
            case 4:
                for (String fg : FOREGROUNDS) {
                    for (String bg : BACKGROUNDS2)
                        System.out.print(fg + bg + "It's the yellow time! ");
                }
                break;
            case 5:
                for (String fg : FOREGROUNDS) {
                    for (String bg : BACKGROUNDS2)
                        System.out.print(fg + bg + "It's the yellow time! ");
                }
                break;
            case 6:
                for (String fg : FOREGROUNDS) {
                    for (String bg : BACKGROUNDS3)
                        System.out.print(fg + bg + "It's the red time! ");
                }
                break;
            case 7:
                for (String fg : FOREGROUNDS) {
                    for (String bg : BACKGROUNDS3)
                        System.out.print(fg + bg + "It's the red time! ");
                }
                break;
            case 8:
                for (String fg : FOREGROUNDS) {
                    for (String bg : BACKGROUNDS3)
                        System.out.print(fg + bg + "It's the red time! ");
                }
                break;
            case 9:
                for (String fg : FOREGROUNDS) {
                    for (String bg : BACKGROUNDS3)
                        System.out.print(fg + bg + "It's the red time! ");
                }
                break;
            case 10:
                for (String fg : FOREGROUNDS) {
                    for (String bg : BACKGROUNDS3)
                        System.out.print(fg + bg + "It's the red time! ");
                }
                break;
            default:
                System.out.println("Wrong number! Try from 0 to 10.");
                break;
        }
    }
}

