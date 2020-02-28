package homeworks.homework1;

import homeworks.InputReader;

public class TrafficLight {

    public void calculateColor() {
        System.out.println("Введите минуты для рассчета цвета сигнала светофора или отрицательное значение для " +
                                   "выхода" + " из программы");
        int minutes;
        TrafficLight trafficLight = new TrafficLight();
        do {
            minutes = InputReader.nextInt();
            System.out.println(trafficLight.getColor(minutes));
        } while (minutes >= 0);
    }

    public String getColor(int minutes) {
        minutes = getProcessedMinutes(minutes);
        if (minutes >= 6) {
            return Colors.Red + " color";
        } else if (minutes >= 3) {
            return Colors.Yellow + " color";
        } else {
            return Colors.Green + " color";
        }
    }

    public int getProcessedMinutes(int minutes) {
        if (minutes >= 10) {
            minutes %= 10;
        } else if (minutes < 0) {
            return Math.abs(minutes % 10);
        }
        return minutes;
    }

}