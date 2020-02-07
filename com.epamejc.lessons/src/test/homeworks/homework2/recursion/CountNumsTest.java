package homeworks.homework2.recursion;

import homeworks.control.exeption.IllegalDataException;
import homeworks.control.services.Service;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountNumsTest {

    CountNums countNums;

    @Before
    public void init(){
        countNums = new CountNums();
    }

    @Test
    public void testCount(){

        String first = "1";
        String zero = "0";
        String two = "12";
        String many = "121021020";
        String manyMinus = "-121021020";


        assertEquals(String.valueOf(first.length()),countNums.getResult(first));
        assertEquals(String.valueOf(zero.length()),countNums.getResult(zero));
        assertEquals(String.valueOf(two.length()),countNums.getResult(two));
        assertEquals(String.valueOf(many.length()),countNums.getResult(many));
        assertEquals(String.valueOf(manyMinus.length()-1),countNums.getResult(manyMinus));

    }
    @Test(expected = IllegalDataException.class)
    public void testEmpty(){
        countNums.getResult("");
        countNums.getResult("12.12");
        countNums.getResult("");

    }

    @Test
    public void testMessage(){
        String expectedMes1 = "Incorrect Input test is not Integer.";
        String test = "test";
        try {
            countNums.getResult(test);
        } catch (IllegalDataException ex){
            assertEquals(expectedMes1,ex.getMessage());
        }
        String expectedMes2 = "Incorrect Input  is not Integer.";
        String test2 = "";
        try {
            countNums.getResult(test2);
        } catch (IllegalDataException ex){
            assertEquals(expectedMes2,ex.getMessage());
        }
        String expectedMes3 = "Incorrect Input 212test is not Integer.";
        String test3 = "212test";
        try {
            countNums.getResult(test3);
        } catch (IllegalDataException ex){
            assertEquals(expectedMes3,ex.getMessage());
        }
        String expectedMes4 = "Incorrect Input 212.12 is not Integer.";
        String test4 = "212.12";
        try {
            countNums.getResult(test4);
        } catch (IllegalDataException ex){
            assertEquals(expectedMes4,ex.getMessage());
        }
    }

}