package lessons.lesson6.example5;

public class Main {

    public static void main(String[] args) {

    }

}

class A implements Course, BaseCourse {

    @Override
    public void print() {
        System.out.println(BaseCourse.x);
        System.out.println(Course.x);
    }
}
