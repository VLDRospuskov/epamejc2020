package homework1;

import java.util.Scanner;

public class trafficLightLogic {
    private String sec;
    private boolean exit = false;

    public void run() {
        while (!exit) {
            System.out.print("Enter sec (-1 to exit): ");
            getSec();
            System.out.println();
            if (Integer.parseInt(sec) == (-1)) {
                exit = true;
            }
            trafficLight trafficLight = new trafficLight();
            System.out.print(trafficLight.selectColor(sec));
        }
    }

    private void getSec() {
        sec = new Scanner(System.in).nextLine();
    }
}
