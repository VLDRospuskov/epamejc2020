package main.Homeworks.HW3.Task_2_3;

import java.util.Scanner;

public class Pyramid {
    private boolean appInputExitTrigger = true;
    private int pyramidHeight;

    public void run() {
        Scanner scan = new Scanner(System.in);
        while (appInputExitTrigger)
        {
            defineTriangleHeight(scan);
            if (appInputExitTrigger)
            {
                System.out.println("Construction completed:");
                printPyramid();
            }
        }
        scan.close();

    }

    private void defineTriangleHeight(Scanner _scan)
    {
        boolean isInputCorrect = false;
        while (!isInputCorrect)
        {
            System.out.print("Enter the height of the pyramid (Integer number from 1 to 55) or enter -1 to exit: ");
            String inputString = _scan.nextLine();
            try {
                pyramidHeight = Integer.parseInt(inputString);
                if (pyramidHeight == -1){
                    appInputExitTrigger = false;
                    break;
                } else if (pyramidHeight > 0 && pyramidHeight <= 55){
                    isInputCorrect = true;
                }
            } catch (Exception ex) { }
        }
    }

    private void printPyramid(){
        int lineElemsCounter = 1;
        System.out.println("");
        for (int i = 0; i < pyramidHeight; i++) //Цикл по высоте пирамиды
        {
            for (int j = 0; j < pyramidHeight - i-1; j++) //Печатаем пробелы слева
            {
                System.out.print(" ");
            }

            for (int k = 0; k < lineElemsCounter; k++) //Печатаем элементы пирамиды
            {
                System.out.print("X");
            }

            for (int z = 0; z < pyramidHeight - i-1; z++) //Печатаем пробелы справа
            {
                System.out.print(" ");
            }

            lineElemsCounter = lineElemsCounter + 2;
            System.out.println("");
        }
        System.out.println("");
    }
}
