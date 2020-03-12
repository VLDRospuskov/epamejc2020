package lessons.java.lesson13.example2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }

        System.out.println();

        for (Integer number : list) {
            System.out.print(number);
        }

        System.out.println();
        // =========
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }

        System.out.println();

//        Consumer<Integer> consumer = o -> System.out.println(o);
        list.forEach(o -> System.out.println(o));
//        Consumer<Integer> print = System.out::print;
        list.forEach(System.out::print);

        System.out.println();

        Integer[] array = new Integer[] {1, 2, 3};
        MyCollection myCollection = new MyCollection(array);
        for (Integer integer : myCollection) {
            System.out.println(integer);
        }
        myCollection.forEach(i -> System.out.println(i));
    }

}

class MyCollection implements Iterable<Integer> {

    private Integer[] array;

    public MyCollection(Integer[] array) {
        this.array = array;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {

            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < array.length;
            }

            @Override
            public Object next() {
                return array[currentIndex++];
            }
        };
    }
}