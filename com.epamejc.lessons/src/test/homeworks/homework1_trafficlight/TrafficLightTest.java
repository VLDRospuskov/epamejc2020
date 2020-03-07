package homeworks.homework1_trafficlight;




import homeworks.control.exeption.IllegalDataException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrafficLightTest {
    private TrafficLight traffic;
    private String red = "Red";
    private String yellow = "Yellow";
    private String green = "Green";
    private String desc = "The traffic light is: ";
    @Before
    public void init(){
       traffic = new TrafficLight();
    }
    @Test
    public void testGetResult() {
        /**
         * test
         * minutes:seconds
         * */
        String redLight = "10:20";
        String yellowLight = "13:22";
        String greenLight = "18:00";

        assertEquals(desc + red,traffic.getResult(redLight));
        assertEquals(desc + yellow,traffic.getResult(yellowLight));
        assertEquals(desc + green,traffic.getResult(greenLight));
        /**
         * test
         * minutes
         * */
        String redMin = "1";
        String yellowMin = "4";
        String greenMin = "8";

        assertEquals(desc + red,traffic.getResult(redMin));
        assertEquals(desc + yellow,traffic.getResult(yellowMin));
        assertEquals(desc + green,traffic.getResult(greenMin));
        String fault10 = "2:";
        traffic.getResult(fault10);

    }
    @Test(expected = IllegalDataException.class)
    public void testGetSumOfStringsWithIncorrectValues() {
        String fault1 = "wqeqwe";
        traffic.getResult(fault1);
    }
}