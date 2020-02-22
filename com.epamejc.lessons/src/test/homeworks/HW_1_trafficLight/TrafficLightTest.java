package homeworks.HW_1_trafficLight;

import org.junit.*;

import static org.junit.Assert.*;

public class TrafficLightTest {
    public static TrafficLight trafficLight;

    @BeforeClass
        public static void setup() {
        trafficLight = new TrafficLight();
        System.out.println("SETUP BEFORE CLASS");
    }

    @AfterClass
    public static void after2() {
        System.out.println("AFTER CLASS");
    }


    @Test
    public void testCheckIfPositive() {
        int actual = trafficLight.zeroIfNegative(5);
        int expected = 5;
        assertEquals(actual, expected);

        actual = trafficLight.zeroIfNegative(0);
        expected = 0;
        assertEquals(actual, expected);

        actual = trafficLight.zeroIfNegative(-2);
        expected = 0;
        assertEquals(actual, expected);
    }

}
