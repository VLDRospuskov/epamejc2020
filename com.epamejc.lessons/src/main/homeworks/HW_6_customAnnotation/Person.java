package homeworks.HW_6_customAnnotation;

public class Person {
    String name;
    int age;

    @MyAnnotation(name = "Ilya", age = 23)
    public Person() throws Exception {
        MyAnnotation myAnnotation = getClass().getConstructor().getAnnotation(MyAnnotation.class);
        this.name = myAnnotation.name();
        this.age = myAnnotation.age();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
