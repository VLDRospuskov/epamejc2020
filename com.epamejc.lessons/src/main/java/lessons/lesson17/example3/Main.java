package lessons.lesson17.example3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Animal<Integer> animal1 = new Animal<>(100);
        Animal<Double> animal2 = new Animal<>(300.345);
         animal1.resultWeight(() -> animal1.getWeight(), number -> System.out.println(number));
         animal2.resultWeight(() -> animal2.getWeight(), number -> System.out.println(number));
    }

}

@Data
@AllArgsConstructor
class Animal<T> {

    private T weight;

    public T getWeight() {
        return weight;
    }

    public void resultWeight(Supplier<? extends T> supplier, Consumer<? super T> consumer) {
        consumer.accept(supplier.get());
    }

}
