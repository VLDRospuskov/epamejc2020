package lessons.lesson16.example3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("tiger", 10));
        animals.add(new Animal("shark", 5));
        animals.add(new Animal("lion", 13));

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("barsik", 8, 3000));
        cats.add(new Cat("murzik", 4, 5000));
        cats.add(new Cat("rijik", 11, 1000));

        List<Kitty> kitties = new ArrayList<>();
        kitties.add(new Kitty("kitty", 1, 500));

        Comparator<Animal> comparatorByAge = new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return o1.getAge() - o2.getAge();
            }
        };

        Comparator<Cat> comparatorByWeight = new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        };

        Comparator<Object> comparatorByHashCode = new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return Integer.compare(o1.hashCode(), o2.hashCode());
            }
        };

        /**
         * extends - ГРАНИЦА максимум Cat и ВСЕ ЧТО НИЖЕ (<? extends Cat>) Cat, Kitty
         * super - Cat -> SemDemo -> Object
         */
//        sortBy(animals, comparatorByAge);
        sortBy(kitties, comparatorByAge);
        sortBy(cats, comparatorByHashCode);
        sortBy(cats, comparatorByAge);
        sortBy(cats, comparatorByWeight);

        System.out.println(animals);
        System.out.println(cats);
    }

    /**
     * P - Producer
     * E - extends
     * C - Consumer
     * S - super
     */
    // extends/super - experiment
    public static void sortBy(List<? extends Cat> cats, Comparator<? super Cat> comparator) {
//        Cat cat = cats.get(0);
//        Cat cat2 = cats.get(1);
//        comparator.compare(cat, cat2);
        Collections.sort(cats, comparator);
    }

}

@Data
@AllArgsConstructor
class Animal {

    private String name;
    private int age;

    @Override
    public String toString() {
        return "SemDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

@Data
class Cat extends Animal {

    private int weight;

    public Cat(String name, int age, int weight) {
        super(name, age);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", weight=" + weight +
                '}';
    }

}

@Data
class Kitty extends Cat {

    public Kitty(String name, int age, int weight) {
        super(name, age, weight);
    }

}