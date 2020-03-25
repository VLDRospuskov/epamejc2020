package experiments.collections;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Interface Iterable - вершина иерархии всех коллекций в Java
        Iterable<String> iterable = null;
        Iterator<String> iterator = iterable.iterator(); // Возвращает итератор, который позволяет пройтись по коллекции
        iterable.forEach(System.out::println); //Метод forEach проходит по коллекции.
        Spliterator<String> spliterator = iterable.spliterator();//Возвращает Spliterator коллекции. см method();

        //Interface Collection implements Iterable
        Collection<String> collection = null;
//        collection.add(); добавляет в коллекцию элемент
//        collection.addAll(); добавляет в коллекцию все элементы другой коллекции
//        collection.clear(); удаляет все элементы коллекции
//        collection.hashCode(); возвращает hasCode коллекции
//        collection.isEmpty(); возвращает true если коллекция пуста
//        collection.remove(); удаляет элемент из коллекции
//        collection.removeAll(); удаляет все элементы содержащиеся в другой коллекции из текущей
//        collection.size(); возвращает число элементов в коллекции
//        collection.contains(); проверяет содержится ли элемент в коллекции
//        collection.containsAll(); проверяет содержатся ли элементы другой коллекции в текущей
//        collection.removeIf(); принимает в себя интерфейс Predicate в качестве фильтра и удаляет элемент из коллекции
//                               соответствующий условию
//        collection.retainAll();  удаляет все объекты из текущей коллекции, кроме тех, которые содержатся в другой коллекции
//        collection.toArray(); возвращает массив, содержащий все элементы коллекции

    }

    public static void method() {
        ArrayList<String > strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");

        //trySplit делит коллекцию на 2.
        Spliterator<String> spliterator = strings.spliterator();
        Spliterator<String> stringSpliterator = spliterator.trySplit();

        //метод tryAdvance принимает Consumer для прохода по всем элементам Spliterator. вернёт false если элементов нет
        while (spliterator.tryAdvance(System.out::println)) {
            System.out.println("----------------------");
        }

        while (stringSpliterator.tryAdvance(System.out::println)) {
            System.out.println("----------------------");
        }

    }

}
