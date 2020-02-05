package homeworks.HW6_annotations;

import lombok.*;

import java.lang.reflect.Constructor;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Student {
    private int age;
    private String name;

    @StudentAnnotation(name = "Alex", age = 25)
    public Student() {
        try {
            Constructor[] declaredConstructors = Student.class.getDeclaredConstructors();
            StudentAnnotation annotation =
                    (StudentAnnotation) declaredConstructors[0].getAnnotation(StudentAnnotation.class);
            this.age = annotation.age();
            this.name = annotation.name();
            System.out.println("New student object was created successfully");
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        }
    }
}
