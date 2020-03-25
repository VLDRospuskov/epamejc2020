package lessons.java.lesson21.example9;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1111111"); //7
        list.add("11111112222222"); // 14
        list.add("11111112222222333333333"); //23
        list.removeIf(a -> a.length() > 21);
        System.out.println(list.size());
    }
}
