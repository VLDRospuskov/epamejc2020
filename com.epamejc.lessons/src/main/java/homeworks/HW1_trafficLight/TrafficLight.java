package homeworks.HW1_trafficLight;

import java.util.Scanner;


public class TrafficLight {

    private boolean isExitNeeded = false;

    public void run() {
        Scanner scan = new Scanner(System.in);
        try {
            while (!isExitNeeded) {
                int secQuantity = defineNumberOfSeconds(scan);
                if (!isExitNeeded) {
                    System.out.println(defineTrafficLightSignal(secQuantity));
                }
            }
        } catch (Exception exc) {
            System.out.println("Traffic light is broken: " + exc.toString());
        } finally {
            scan.close();
            System.out.println(TrafficLightColors.appFinishMessage.getMessage());
        }

    }

    /**
     * Method for initializing the number seconds
     *
     * @param scan scanner object
     * @return number of seconds
     */
    public int defineNumberOfSeconds(Scanner scan) {
        boolean linesInputExitTrigger = false;
        int secondsNumber = 0;
        while (!linesInputExitTrigger) {
            System.out.print(TrafficLightColors.enterStringMessage.getMessage());
            String inputString = scan.nextLine();
            try {
                secondsNumber = Integer.parseInt(inputString);
                if (secondsNumber == -1) {
                    isExitNeeded = true;
                    break;
                } else if (secondsNumber > 0) {
                    linesInputExitTrigger = true;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception arExc) {
                System.out.println(TrafficLightColors.incorrectInputMessage.getMessage());
            }
        }
        return secondsNumber;
    }

    /**
     * Method for determining the color of a traffic signal
     *
     * @param num number of seconds
     * @return traffic light
     */
    public String defineTrafficLightSignal(int num) {
        num = num % 600; //контур на 10 минут

        if (num >= 0 && num <= 180) {
            return TrafficLightColors.GREEN.getMessage();
        } else if (num > 180 && num <= 300) {
            return TrafficLightColors.YELLOW.getMessage();
        } else if (num > 300) {
            return TrafficLightColors.RED.getMessage();
        } else {
            return TrafficLightColors.incorrectInputMessage.getMessage();
        }
    }
}
