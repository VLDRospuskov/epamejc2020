package main.seabattle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gan {

    private List<Integer> list;

    public Gan() {
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
    }

    public int takeAttack() {
        if (!(list.isEmpty())) {
            int i = list.get(0);
            list.remove(0);
            return i;
        } else {
            return -1;
        }
    }

}
