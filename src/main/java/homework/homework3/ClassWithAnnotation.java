package homework.homework3;

import lombok.Data;

import java.lang.annotation.Annotation;

@Data
public class ClassWithAnnotation {

    private String name;
    private int age;

    @CustomAnnotation
    public ClassWithAnnotation(){
        CustomAnnotation annotation = getClass().getDeclaredConstructors()[0].getAnnotation(CustomAnnotation.class);

            System.out.println(annotation);
            if (annotation != null) {
                name = annotation.name();
                age = annotation.age();
            }
            else {
                throw new RuntimeException("Constructor must have a CustomAnnotation annotation");
            }
    }
}
