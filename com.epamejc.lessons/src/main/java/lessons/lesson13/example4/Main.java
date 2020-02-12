package lessons.lesson13.example4;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(1000);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
//        ListIterator<Integer> listIterator = arrayList.listIterator();
        System.out.println(arrayList);
        List<Integer> list = new ArrayList<>();
        list = arrayList.subList(0, 3);
//        list.remove(1);
        list.add(100);
        list.add(2354);
        System.out.println(arrayList);
        System.out.println(list);

//        Integer set = arrayList.set(3, 10000);
//        ArrayList<Integer> arrayList2 = new ArrayList<>(1000);
//        arrayList2.add(1);
//        arrayList2.add(2);
//        arrayList2.add(3);
//        arrayList2.add(100);
//        arrayList2.add(999);
//        arrayList.removeAll(arrayList2);
        // _ _ _ _ _ _ _ _ _ _
        // 1 2 3 4 5 6 7 8 9 10
        // 1 2 3 4 5 100 6 7 8 9 10 11 _ _ _ _
//        System.out.println(arrayList.size());
//        System.out.println(arrayList2.size());

//        System.out.println(set);
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.addFirst(1);

    }

}
