package lessons.java.lesson22.example8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat("Barsik", 10));
        catList.add(new Cat("Rijik", 7));
        catList.add(new Cat("Murzik", 10));
        ConcurrentMap<Integer, List<Cat>> collect =
                catList.stream().collect(Collectors.groupingByConcurrent(Cat::getAge));
        System.out.println(collect);
        // 7 - {rijik} 10 - {barsik murzik}
    }

}

@Data
@AllArgsConstructor
@ToString
class Cat {

    private String name;
    private int age;

    @Override
    public String toString() {
        return "Main{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}