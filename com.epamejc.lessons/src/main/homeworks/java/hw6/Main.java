package homeworks.java.hw6;

public class Main {

    public static void main(String[] args) {
        Person person = null;

        try {
            person = new Person();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
    }

}
