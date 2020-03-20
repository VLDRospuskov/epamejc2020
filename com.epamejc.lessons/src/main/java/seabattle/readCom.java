package seabattle;

import java.util.Scanner;

class readCom {
    // todo сделать проверку введены целые цифры в диапозоне действия инта
    int readCom() {

        boolean t = false;
        int command = 0;
        do {
            try {
                Scanner in = new Scanner(System.in);
                command = in.nextInt();
                t=false;
            }
            catch (Exception e)
            {
              t=true;
                System.out.println("ERR");
            }

        } while (t);

        return command;
    }

}
