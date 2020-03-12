package lessons.lesson14.example8;

import java.util.TreeMap;

public class Main {
    
    public static void main(String[] args) {
        TreeMap<Cat, String> catsTree = new TreeMap<>();
        catsTree.put(new Cat(10), "rijik");
        catsTree.put(new Cat(2), "barsik");
        catsTree.put(new Cat(23), "murzik");
        System.out.println(catsTree);
    }
    
}
