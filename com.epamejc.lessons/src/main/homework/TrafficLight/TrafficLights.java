package homework.TrafficLight;

import javax.swing.JOptionPane;

public class TrafficLights {
    public static void colorCheck(double time) {
        if (time < 0 || time > 10) {
            System.exit(0);
        }
        if (time >= 0 && time < 3) {
            JOptionPane.showMessageDialog(null, "Сейчас горит зеленый");
        } else if (time >= 3 && time < 5) {
            JOptionPane.showMessageDialog(null, "Сейчас горит желтый");
        } else if (time >= 5 && time <= 10) {
            JOptionPane.showMessageDialog(null, "Сейчас горит красный");
        }
    }
}

