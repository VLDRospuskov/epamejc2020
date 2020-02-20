package Homeworks.HW4;


public class Main {

    @MyAnnotation(name="Alice", age=30)
    static Person person;

    public static void main(String[] args) {
        person =  new Person();
        //person1.toString(); // error

      //  @MyAnnotation(name="Bob", age=20)
    //    Person person2 = new Person();
        String name = person.getClass().getDeclaredAnnotation(MyAnnotation.class).name();
        System.out.println(name);
    }
}
