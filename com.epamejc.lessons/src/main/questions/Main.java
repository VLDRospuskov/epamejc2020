package questions;

import java.lang.annotation.*;

public class Main {

    public static void main(String[] args) {

//        @SampleAnnotation(name = "asdf", age = 123)
//        Person person = new Person();
//Person
//        Method[] declaredMethods = Main.class.getDeclaredMethods();
//        AnnotatedType annotatedReceiverType = declaredMethods[0].getAnnotatedReceiverType();
//        AnnotatedType annotatedReturnType = declaredMethods[0].getAnnotatedReturnType();
//        Annotation[] annotations = annotatedReceiverType.getAnnotations();

        @MyAnnotation(name = "peter", age = "123")
        Person person = new Person();


//        SampleAnnotationContainer annotation = person.getClass().getAnnotation(SampleAnnotationContainer.class);
//        Thread main = Thread.currentThread();
//        Annotation[] annotations = SampleAnnotationContainer.value();

//        Annotation[] annotations = main.getClass().getDeclaredAnnotations();
//
//
//        String s = new String("This is a sample");
//
//        Class type = s.getClass();
//        boolean tr = type.isLocalClass();
//        for ( Field f : type.getFields() ) {
//            System.out.printf("Field %s is of type %s%n", f.getName(), f.getType().getName());
//        }
//
//        System.out.println(person);
    }
}
