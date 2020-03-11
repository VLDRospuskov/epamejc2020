package homeworks.seabatle.servises.locationservice;

import homeworks.seabatle.exception.IncorrectInputParseException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LocationServiceImplTest {
    private LocationService service;
    private String req1 = "C4";
    private String req2 = "C4 C7";
    private String req3 = "C4 F4";
    private String req4 = "C4 dq";
    private String req5 = "qwe";
    private String req6 = "";
    private String req7 = "C1 D29";
    private String req8 = "CC";
    private String req9 = "C A A";

    @Before
    public void setUp() throws Exception {
        service = new LocationServiceImpl();
    }

    @Test
    public void testTranslateRequest() {
        String exp1 = "A1";
        String exp2 = "E4";
        String exp3 = "J10";
        int req1 = 0;
        int req2 = 43;
        int req3 = 99;
        assertEquals(exp1, service.translateRequest(req1));
        assertEquals(exp2, service.translateRequest(req2));
        assertEquals(exp3, service.translateRequest(req3));
    }

    @Test
    public void testGetCoordinates() {
        int[] expected1 = {23};
        int[] expected2 = {23, 24, 25, 26};
        int[] expected3 = {23, 33, 43, 53};

        assertArrayEquals(expected1, service.getCoordinates(req1));
        System.out.println(Arrays.toString(service.getCoordinates(req2)));
        assertArrayEquals(expected2, service.getCoordinates(req2));
        assertArrayEquals(expected3, service.getCoordinates(req3));
    }

    @Test(expected = IncorrectInputParseException.class)
    public void testGetFake1Coordinates() {
        service.getCoordinates(req4);
    }

    @Test(expected = IncorrectInputParseException.class)
    public void testGetFake2Coordinates() {
        service.getCoordinates(req5);
    }

    @Test(expected = IncorrectInputParseException.class)
    public void testGetFake3Coordinates() {
        service.getCoordinates(req6);
    }

    @Test(expected = IncorrectInputParseException.class)
    public void testGetFake4Coordinates() {
        service.getCoordinates(req7);
    }

    @Test(expected = IncorrectInputParseException.class)
    public void testGetFake5Coordinates() {
        service.getCoordinates(req8);
    }

    @Test(expected = IncorrectInputParseException.class)
    public void testGetFake6Coordinates() {
        service.getCoordinates(req9);
    }

}