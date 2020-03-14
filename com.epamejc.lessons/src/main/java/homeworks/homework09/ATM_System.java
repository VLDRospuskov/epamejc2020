package homeworks.homework09;

import java.util.ArrayList;
import java.util.List;

public class ATM_System {

    final static List<ATM> atmList = new ArrayList<>();

    public ATM_System(int value) {
        for (int i = 0; i < value; i++) {
            atmList.add(new ATM());
        }
    }

}
