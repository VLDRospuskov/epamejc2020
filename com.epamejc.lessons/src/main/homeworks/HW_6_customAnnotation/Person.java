package homeworks.HW_6_customAnnotation;

import lombok.Data;
import lombok.SneakyThrows;

@Data
public class Person {
    private String name;
    private int age;

    @MyAnnotation(name = "Ilya", age = 23)
    public Person() {
        this.name = getMyAnnotation().name();
        this.age = getMyAnnotation().age();
    }

    @SneakyThrows
    private MyAnnotation getMyAnnotation() {
        return getClass().getConstructor().getAnnotation(MyAnnotation.class);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
