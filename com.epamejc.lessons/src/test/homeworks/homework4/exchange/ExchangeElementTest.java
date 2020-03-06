package test.homeworks.homework4.exchange;

import main.homeworks.homework4.exchange.ExchangeElement;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExchangeElementTest {

    private ExchangeElement exchangeElement;

    @Before
    public void setup() {
        exchangeElement = new ExchangeElement();
    }

    @Test
    public void test1Exchange() {
        exchangeElement.setInput("This is string");
        exchangeElement.setFirstIndex(4);
        exchangeElement.setSecondIndex(11);
        String expected = "Thisiis str ng";
        String actual = exchangeElement.exchange();
        assertEquals(expected, actual);
    }

    @Test
    public void test2Exchange() {
        exchangeElement.setInput("ab");
        exchangeElement.setFirstIndex(0);
        exchangeElement.setSecondIndex(1);
        String expected = "ba";
        String actual = exchangeElement.exchange();
        assertEquals(expected, actual);
    }

    @Test
    public void test3Exchange() {
        exchangeElement.setInput("epam");
        exchangeElement.setFirstIndex(0);
        exchangeElement.setSecondIndex(3);
        String expected = "mpae";
        String actual = exchangeElement.exchange();
        assertEquals(expected, actual);
    }

}
