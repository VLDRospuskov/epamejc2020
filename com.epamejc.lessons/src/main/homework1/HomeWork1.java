package main.homework1;

/*Создать "светофор", который выводит сигнал-цвет. Вы вводите время от 0-3 минуты - зеленый,
4-5 минуты - желтый, 6-10 красный. Вводим цифру 0 до n, получаем результат. Работу программы
сделать непрерывной, выход можно обработать.*/

public class HomeWork1 {

    public static void main(String[] args) {

        TrafficLight trafficLight = new TrafficLight();
        trafficLight.start();
    }
}