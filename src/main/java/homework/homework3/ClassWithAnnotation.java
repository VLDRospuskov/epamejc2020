package homework.homework3;

import lombok.Data;

import java.lang.annotation.Annotation;

@Data
public class ClassWithAnnotation {

    private String name;
    private int age;

    @CustomAnnotation(name = "Yana", age = 24)
    public ClassWithAnnotation(){
    }
}
