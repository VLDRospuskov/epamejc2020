package lessons.lesson15.example5;

import java.util.HashMap;
import java.util.function.BiFunction;

public class Main {

    /**
     *
     * a 00000
     * b 11111
     *
     * a aaaaa
     * b bbbbb
     */
    public static void main(String[] args) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("a", "00000");
        stringStringHashMap.put("b", "11111");
        HashMap<String, String> stringStringHashMap2 = new HashMap<>();
        stringStringHashMap2.put("a", "aaaaa");
        stringStringHashMap2.put("b", "bbbbb");

//        BiFunction<String, String, String> biFunction = new BiFunction<String, String, String>() {
//            @Override
//            public String apply(String key, String value) {
//                String put = stringStringHashMap.put(key, value);
//                return put;
//            }
//        };
//        stringStringHashMap2.replaceAll(biFunction);

        stringStringHashMap2.replaceAll(stringStringHashMap::put);

        System.out.println(stringStringHashMap);
        System.out.println(stringStringHashMap2);
    }
}
