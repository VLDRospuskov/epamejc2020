package seabattle;

import java.util.Scanner;

class ReadCommands {
    int readCom(String text) {

        boolean t;
        int command = 0;
        do {
            try {
                System.out.print(text);
                Scanner in = new Scanner(System.in);
                command = in.nextInt();
                t=false;
            }
            catch (Exception e)
            {
              t=true;
                System.out.println("Input Error.");
            }

        } while (t);

        return command;
    }

}
