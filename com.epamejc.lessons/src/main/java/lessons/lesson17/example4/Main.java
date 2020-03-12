package lessons.lesson17.example4;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Supplier;

public class Main {
    
    public static void main(String[] args) {
        Animal<Integer> animal1 = new Animal<>(100); // Double
        Animal<Double> animal2 = new Animal<>(300.345); // Integer
        Animal<Float> animal3 = new Animal<>(2356.345f); // Boolean
        
        animal2.resultWeight(() -> animal2.getWeight2(), (number) -> number.intValue());
        
        animal2.resultWeight(() -> animal2.getWeight(), (number) -> number.intValue());
    }
    
}

@Data
@AllArgsConstructor
class Animal <T> {
    
    private T weight;
    
    public T getWeight() {
        return weight;
    }
    
    public Number getWeight2() {
        return 1000;
    }
    
    public <R> R resultWeight(Supplier<? extends Number> supplier, MyFunction<? super Number, ? extends R> myFunction) {
        Number number = supplier.get();
        R r1 = myFunction.applyFunc(number);
        return r1;
    }
    
}