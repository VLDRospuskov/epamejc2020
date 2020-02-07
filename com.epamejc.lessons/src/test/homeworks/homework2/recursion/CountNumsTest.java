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
        countNums.getResult("12 12");

    }

    @Test
    public void testMessage(){

        String expPart2 = " is not Integer.";
        String test = "test";
        try {
            countNums.getResult(test);
        } catch (IllegalDataException ex){
            assertEquals(test+expPart2,ex.getMessage());
        }

        String test2 = "";
        try {
            countNums.getResult(test2);
        } catch (IllegalDataException ex){
            assertEquals(test2+expPart2,ex.getMessage());
        }
        String test3 = "212test";
        try {
            countNums.getResult(test3);
        } catch (IllegalDataException ex){
            assertEquals(test3+expPart2,ex.getMessage());
        }
        String test4 = "212.12";
        try {
            countNums.getResult(test4);
        } catch (IllegalDataException ex){
            assertEquals(test4+expPart2,ex.getMessage());
        }
        String test5 = "212 12";
        try {
            countNums.getResult(test5);
        } catch (IllegalDataException ex){
            assertEquals(test5+expPart2,ex.getMessage());
        }
    }

}