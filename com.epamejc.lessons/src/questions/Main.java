package questions;

import java.lang.annotation.Annotation;

public class Main {

    public static void main(String[] args) {

        @MyAnnotation(name = "asdf", age = "234")
        Person person = new Person();

        Thread main = Thread.currentThread();

        Annotation[] annotations = main.getClass().getDeclaredAnnotations();



        System.out.println(person);
    }
}
