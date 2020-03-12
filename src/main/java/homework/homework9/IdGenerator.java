package homework.homework9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IdGenerator {

    public static List<Integer> generateIds(int count){
        Random random = new Random();
        List<Integer> ids = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int newId = 1+ random.nextInt(30);
            while (ids.contains(newId)){
                newId = 1+ random.nextInt(30);
            }
            ids.add(newId);
        }
        return ids;
    }
}
