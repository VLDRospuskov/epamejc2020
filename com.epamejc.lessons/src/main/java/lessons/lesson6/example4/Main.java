package lessons.lesson6.example4;

public class Main {
    public static void main(String[] args) {
        CourseHelper bch = new BaseCourseHelper();
        Course course = bch.getCourse();
        System.out.println(bch.getClass());
        //ошибка компиляции
        bch.getCourse();

    }
}

class Course{}
class BaseCourse extends Course{}

class CourseHelper {
    public Course getCourse(){
        System.out.println("Course");
        return new Course();
    }
}
class BaseCourseHelper extends CourseHelper {
    public BaseCourse getCourse(){
        System.out.println("BaseCourse");
        return new BaseCourse();
    }
}
