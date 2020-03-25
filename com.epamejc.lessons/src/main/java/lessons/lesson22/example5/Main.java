package lessons.java.lesson22.example5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.*;

public class Main {

    static {
        Cat.color = "Orange";
    }

    @SneakyThrows
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 10);
        try (ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream(new File("file.txt")))) {
            objectOutputStream.writeObject(cat);
        }

        try (ObjectInputStream objectInputStream =
                     new ObjectInputStream(new FileInputStream("file.txt"))) {
            Cat fromFileCat = (Cat) objectInputStream.readObject();
            System.out.println(
                    fromFileCat.getName() + " " +
                            fromFileCat.getAge() + " " +
                            fromFileCat.getColor());
        }
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Cat implements Serializable {

    private String name;
    private transient int age;
    public static String color = "Black";

    public static String getColor() {
        return color;
    }
}
