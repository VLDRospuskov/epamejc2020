package lessons.java.lesson14.example2;

import java.util.Comparator;
import java.util.PriorityQueue;

// slack
public class Main {

    public static void main(String[] args) {
        PriorityQueue<Integer> integers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        integers.add(2);
        integers.add(33);
        integers.add(56);
        integers.add(1);
        integers.add(55);
//        integers.offer(63);
        System.out.println(integers);
    }
}
