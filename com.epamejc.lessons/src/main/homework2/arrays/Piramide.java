package main.homework2.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Piramide {
    public static void main(String[] args) throws IOException {
        Piramide piramide = new Piramide();
        piramide.go();
    }
    public void go() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int piLenght= 0;

        String exit = "exit";

        String alert = "Wrong data!";

        System.out.println("Введите число!");

        String length = reader.readLine();
            try {
                piLenght = Integer.parseInt(length);

                Character[][] strings = new Character[piLenght][];

                Character ab;

                Random r = new Random();

                ab =  (char)(r.nextInt(26) + 'a');

                for (int i = 0; i < piLenght; i++){
                    Character[] simb = new Character[piLenght-i];
                    for(int j = 0; j < piLenght-i; j++){
                        simb[j] = ab;
                    }
                    strings[i] = simb;
                }
                for (int i = 0; i < piLenght; i++){
                    for(int j = 0; j < piLenght-i; j++){
                        System.out.print(strings[i][j]);
                    }
                    System.out.println();
                }
            } catch (Exception ex){
                ex.printStackTrace();

            } finally {
                reader.close();
            }

    }
}
