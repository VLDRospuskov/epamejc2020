package homeworks.homework1;

import homeworks.homework3.allInAll.Colors;

public class ColorPrinter {

    public void printColor (double time) {
        if (time >= 0 && time < 4.0) {
            System.out.println(Colors.colors[3] + TrafficColors.GREEN + Colors.colors[0]);
        } else if (time >= 4.0 && time < 6.0) {
            System.out.println(Colors.colors[4] + TrafficColors.YELLOW + Colors.colors[0]);
        } else if (time >= 6.0 && time <= 10.0) {
            System.out.println(Colors.colors[2] + TrafficColors.RED + Colors.colors[0]);
        } else {
            System.out.println("Out of range('0-4', '4-6', '6-10')");
        }
    }
}
