package homeworks.homework00;

import org.junit.Assert;
import org.junit.Test;

/**
 * TODO
 * можно ли делать тесты без ассерта?
 * Если с ним, то необходимо делать очень много тестов?
 */

public class TrafficLightTest {

    private TrafficLight trafficLight = new TrafficLight();

    @Test
    public void launchGreen() {
        String expected = "Green";

        for (int i = 1; i <= 4; i++) {
            //TODO можно ли инициализировать actual и вызывать assert в цикле?
            // Или нужно делать 4 разных теста для каждого значения?
            // Или можно обойтись тремя: крайние значения и внутренние?
            String actual = trafficLight.getTrafficLightColorFromMinute(i);

            Assert.assertEquals(expected, actual);
        }

    }

    @Test
    public void launchYellow() {
        String expected = "Yellow";

        for (int i = 5; i <= 7; i++) {
            String actual = trafficLight.getTrafficLightColorFromMinute(i);

            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void launchRed() {
        String expected = "Red";

        for (int i = 8; i <= 10; i++) {
            String actual = trafficLight.getTrafficLightColorFromMinute(i);

            Assert.assertEquals(expected, actual);
        }
    }

    @Test
    public void launchOutOfBorders() {
        String expected = "It is broken!";
        String actual = trafficLight.getTrafficLightColorFromMinute(-1);

        Assert.assertEquals(expected, actual);

        actual = trafficLight.getTrafficLightColorFromMinute(11);
        //TODO Можно ли дважды в одном тесте инициализировать actual и вызвать assert?
        // Если нет, то как нужно сделать?

        //TODO Как тестировать случаи, где ожидаемым результатом является ошибка, но вариантов неправильного ввода много?
        // Создавать для каждого новый тест?
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void launchWrongInputs() {
        //TODO после рефактора остался только один метод для тестирования, т.к. непонятно как тестировать методы с
        // консольным вводом. Следовательно, можно ли обойтись без тестирования неверного ввода?
    }
}
