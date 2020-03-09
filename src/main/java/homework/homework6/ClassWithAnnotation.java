package homework.homework6;

import lombok.Data;

@Data
public class ClassWithAnnotation {

    private String name;
    private int age;

    @CustomAnnotation(name = "Yana", age = 24)
    public ClassWithAnnotation(){
    }
}
