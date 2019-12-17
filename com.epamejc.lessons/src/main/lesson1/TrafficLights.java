package main.lesson1;

import javax.swing.JOptionPane;
/*
Создать "светофор", который выводит сигнал-цвет. Вы вводите время от 0-3 минуты - зеленый,
4-5 минуты - желтый, 6-10 красный. Вводим цифру 0 до n, получаем результат. Работу программы
сделать непрерывной, выход можно обработать
 */

public class TrafficLights {
    public static void colorCheck(double time) {
        if (time < 0 || time > 10) {
            System.exit(-1);
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

