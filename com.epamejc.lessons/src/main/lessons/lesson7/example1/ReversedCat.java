package main.lessons.lesson7.example1;

import java.util.Comparator;

public class ReversedCat implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }

}
