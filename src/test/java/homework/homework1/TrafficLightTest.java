package homework.homework1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static homework.homework1.TrafficLight.*;
import static org.junit.Assert.assertEquals;

public class TrafficLightTest {

    private TrafficLight trafficLight;

    private InputStream sysInBackup;
    private PrintStream sysOutBackup;

    private ByteArrayOutputStream baOutputStream;

    @Before
    public void setUp() {
        trafficLight = new TrafficLight();

        sysInBackup = System.in;
        sysOutBackup = System.out;

        ByteArrayInputStream baInputStream = new ByteArrayInputStream("0.0\n4\n9\nq".getBytes());
        System.setIn(baInputStream);

        baOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baOutputStream));
    }

    @After
    public void setDown() {
        System.setIn(sysInBackup);
        System.setOut(sysOutBackup);
    }

    @Test
    public void getColorForTime() {
        assertEquals(GREEN, trafficLight.getColorForTime(0.0));
        assertEquals(GREEN, trafficLight.getColorForTime(1.5));
        assertEquals(GREEN, trafficLight.getColorForTime(3.0));
        assertEquals(YELLOW, trafficLight.getColorForTime(3.01));
        assertEquals(YELLOW, trafficLight.getColorForTime(5.0));
        assertEquals(RED, trafficLight.getColorForTime(5.1));
        assertEquals(RED, trafficLight.getColorForTime(10.0));
        assertEquals(ERR_TIME_VALUE, trafficLight.getColorForTime(10.01));
        assertEquals(ERR_TIME_VALUE, trafficLight.getColorForTime(-1.0));
    }

    @Test
    public void run() {
        trafficLight.run();

        final List<String> colors = findColors(baOutputStream.toString());

        assertEquals(GREEN, colors.get(0));
        assertEquals(YELLOW, colors.get(1));
        assertEquals(RED, colors.get(2));
    }

    private List<String> findColors(String text) {
        String[] linesArray = text.split("\r\n");
        List<String> linesList = new ArrayList<>(Arrays.asList(linesArray));
        List<String> exceptList = new ArrayList<>(
                Arrays.asList(INFO, INVITATION, ERR_TIME_FORMAT, ERR_TIME_VALUE, QUIT, "")
        );

        linesList.removeAll(exceptList);
        return linesList;
    }
}