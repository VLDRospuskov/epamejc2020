package homeworks.control.commands;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class CommandsTest {

    @Test
    public void testGetDescription() {
        String traffic = "/trafficlight Description: push time in minutes(double) and get TrafficSignal";
        String evenOddStr = "/evenoddstr Description: push to integers with strategy even/odd and get result";
        String pyramid = "/pyramid Description: push one integer and get your Pyramid";
        String randomChar = "/randomchar Description: push two integers and get your matrix";
        String countNums = "/countnums Description: push two integers and get your matrix";
        String poweder = "/pow Description: push one int(num) and one int(pow) and i  will raise to a degree";
        String fibonacci = "/fibonacci Description: push one int i will return a fibonacci number";
        String EvenOdd = "/evenodd Description: push a string and a strategy even or odd and get your result";
        String MakeWord = "/makeword Description: push a string and amount of integers(indexes)" +
                " and i will make new string";
        String RewerseWord = "/rewerseword Description: push a string and i will reverse only words";
        String swirchChar = "/swithchar Description: push a string and two int's indexes and i will switch chars";

        assertEquals(traffic,Commands.TRAFFICLIGHT.getDescription());
        assertEquals(evenOddStr,Commands.EVENODDSTR.getDescription());
        assertEquals(pyramid,Commands.PYRAMID.getDescription());
        assertEquals(randomChar,Commands.RANDOMCHAR.getDescription());
        assertEquals(countNums,Commands.COUNTNUMS.getDescription());
        assertEquals(poweder,Commands.POW.getDescription());
        assertEquals(fibonacci,Commands.FIBONACCI.getDescription());
        assertEquals(EvenOdd,Commands.EVENODD.getDescription());
        assertEquals(MakeWord,Commands.MAKEWORD.getDescription());
        assertEquals(RewerseWord,Commands.REWERSEWORD.getDescription());
        assertEquals(swirchChar,Commands.SWITHCHAR.getDescription());


        List<String> commandNames = new ArrayList<>();
        List<String> actual = new ArrayList<>();

        for (Commands commands : Commands.values()){
            commandNames.add(commands.name().toLowerCase());
            actual.add(commands.toString());
        }

        assertEquals(commandNames,actual);


    }
}