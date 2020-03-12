package lessons.lesson16.example1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    
    public static void main(String[] args) {
        // Consumer
        Consumer<Integer> consumer = new Consumer<Integer>() {
    
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        // Producer
        Supplier<Integer> supplier = new Supplier<Integer>() {
    
            @Override
            public Integer get() {
                return 10;
            }
        };
        
        Supplier<List<Integer>> supplier2 = new Supplier<List<Integer>>() {
            
            @Override
            public List<Integer> get() {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(1);
                integers.add(2);
                integers.add(3);
                return integers;
            }
        };
        
        Consumer<List<Integer>> consumer2 = new Consumer<List<Integer>>() {
            
            @Override
            public void accept(List<Integer> list) {
                list.forEach(System.out::println);
            }
        };
        
        consumer.accept(supplier.get());
    }
    
}
