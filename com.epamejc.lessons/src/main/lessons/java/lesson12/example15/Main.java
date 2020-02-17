package lessons.java.lesson12.example15;

import lombok.SneakyThrows;

import java.io.*;

public class Main {

    public static void main(String[] args) {
//        writer();
        reader();
    }

    @SneakyThrows
    private static void writer() {
//        Geeks g = new Geeks();
        Cat cat = new Cat();
        // Here xyz.ser is the file name where the object is
        // going to serialize
        FileOutputStream fos = new FileOutputStream("xyz.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(cat);

        reader();
    }

    @SneakyThrows
    private static void reader() {
        FileInputStream fis = new FileInputStream("xyz.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
//        Geeks g1 = (Geeks)ois.readObject();
        Cat g1 = (Cat)ois.readObject();
        System.out.println("Deserialized Object Value:" + g1.i + "..."+g1.j + " ");
//        System.out.println("Deserialized Object Value:" + g1.i + "..."+g1.j + " " + g1.name);
//        System.out.println("Deserialized Object Value:" + g1.i + "..."+g1.j + " " + g1.type);
    }
}


class Geeks implements Serializable {

    // User-defined SerialVersionUID
    private static final long serialVersionUID = 201L;

    int i = 10;
    int j = 20;
//    String name = "Geek!!!";
}

class Cat extends Geeks {
    private static final long serialVersionUID = 302L;
    String type = "BIG";
}