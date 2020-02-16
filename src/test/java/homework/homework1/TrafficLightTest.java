package homework.homework1;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class TrafficLightTest {

    @Test
    public void getColorForTime() {
        TrafficLight trafficLight = new TrafficLight();
        Assert.assertEquals("Green", trafficLight.getColorForTime(0.0));
        Assert.assertEquals("Yellow", trafficLight.getColorForTime(5.0));
        Assert.assertEquals("Red", trafficLight.getColorForTime(10.0));
    }

    @SneakyThrows
    @Test
    public void run() {
//        InputStream sysInBackup = System.in; // backup System.in to restore it later
//        ByteArrayInputStream in = new ByteArrayInputStream("0\n4\n9\nq".getBytes());
//        System.setIn(in);
//
//        TrafficLight trafficLight = new TrafficLight();
//        trafficLight.run();
//
//        byte byteArray[] = new byte[0];
//        PrintStream stream =  System.out;
//        System.out.write(byteArray);
//        String result = new String(byteArray);
//        System.out.println("!!!" + result);
//// optionally, reset System.in to its original
//        System.setIn(sysInBackup);

    }
}