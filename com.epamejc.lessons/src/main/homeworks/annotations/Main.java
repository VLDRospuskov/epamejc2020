package main.homeworks.annotations;

public class Main {

    public static void main(String[] args) {

        Person person = new Person();
        System.out.println(person);

        //@MyAnnotation(name = "asdf", age = 234) How to get this annotation via reflection? (Local_variable element type)
        String name = person.getClass().getAnnotation(MyAnnotation.class).name();
        String age = person.getClass().getAnnotation(MyAnnotation.class).age();

        person.setName(name);
        person.setAge(age);

        System.out.println(person);
    }
}
