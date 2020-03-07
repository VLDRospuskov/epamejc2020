package homeworks.homework3_recursion;

import homeworks.control.exeption.IllegalDataException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ExponentiationTest {

    Exponentiation expo;
    @Before
    public void init(){
        expo = new Exponentiation();
    }
    @Test
    public void testCount(){
        int[] nums = {2,3,123,2,11,0,-122,221};
        int[] pows = {2,-3,2,-0,11,2,2,0};

        List<String> expected = new ArrayList<>();
        List<String> actual = new ArrayList<>();
        for( int i = 0 ; i < nums.length; i++){
            expected.add(String.valueOf(Math.pow(nums[i],pows[i])));
            actual.add(expo.getResult(nums[i] + " " + pows[i]));
        }

       assertArrayEquals(expected.toArray(),actual.toArray());

    }

    @Test(expected = IllegalDataException.class)
    public void testNumException(){
        String str ="qwd 2";
        expo.getResult(str);
    }
    @Test(expected = IllegalDataException.class)
    public void testPowException(){
        String str ="2 qwd";
        expo.getResult(str);
    }
    @Test
    public void testExceptionMessage(){
        String[] nums = {"12","2","122","89"};
        String[] illegalPows = {"sdsd","ewew","qewqwe","!we"};

        String[] illegalNums = {"sdsd","","22.2","!"};
        String[] pows = {"12","2","122","89"};

        String[] illegalInput = {"wqeqw","0","12","!202"};

        String isNotInt = " is not Integer.";
        String incorrectInput = " dont contains two ints";

        String[] actualPowEx = new String[nums.length];
        String[] actualNumEx = new String[nums.length];

        String[] expectedPowEx = new String[nums.length];
        String[] expectedNumEx = new String[nums.length];

        String[] expectedAllEx = new String[nums.length];
        String[] actualAllEx = new String[nums.length];

        for (int i = 0; i < nums.length; i++){
            expectedPowEx[i] = illegalPows[i] + isNotInt;
            expectedNumEx[i] = illegalNums[i] + isNotInt;
            expectedAllEx[i] = illegalInput[i] + incorrectInput;
            try {
                expo.getResult(nums[i] + " " + illegalPows[i]);
                fail();
            }catch (IllegalDataException e){
                actualPowEx[i] = e.getMessage();
            }
            try {
                expo.getResult(illegalNums[i] + " " + pows[i]);
                fail();
            }catch (IllegalDataException e){
                actualNumEx[i] = e.getMessage();
            }
            try {
                expo.getResult(illegalInput[i]);
                fail();
            }catch (IllegalDataException e){
                actualAllEx[i] = e.getMessage();
            }
        }
        assertArrayEquals(expectedPowEx,actualPowEx);
        assertArrayEquals(expectedNumEx,actualNumEx);
        assertArrayEquals(expectedAllEx,actualAllEx);
    }




}