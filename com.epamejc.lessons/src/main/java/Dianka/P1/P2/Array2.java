package Dianka.P1.P2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

interface Alex {
    default void write() {}
    static void publish() {}
    void think();
}
interface Michael {
    public default void write() {}
    public static void publish() {}
    public void think();
}
class Twins implements Alex, Michael {
    static class adsf implements Function<Integer, Integer> {
        static void asdf(){}
        @Override
        public Integer apply(Integer integer) {
            return null;
        }
    };
    @Override public void write() {}
     public static void publish() {
         System.out.print("Thinking...");
     }
    @Override public void think() {
        System.out.print("Thinking...");
    }
}

public class Array2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fizzBuzz(1, 16)));
    }

    private static String[] fizzBuzz(int start, int end) {
        ArrayList<String> array = new ArrayList<>();
        int[] nums = new int[end - start];
        for (int i = start; i < end; i++) {
            nums[i - start] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 == 0 && nums[i] % 5 == 0) {
                array.add("FizzBuzz");
            } else if (nums[i] % 3 == 0) {
                array.add("Fizz");
            } else if (nums[i] % 5 == 0) {
                array.add("Buzz");
            } else {
                array.add(String.valueOf(nums[i]));
            }
        }
        return array.toArray(new String[array.size()]);
    }
}


