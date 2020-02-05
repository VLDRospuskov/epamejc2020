package homework.Annotations;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Constructor;

@Getter
@Setter

public class Annotated {
    private String name;
    private int age;

    @CustomAnnotation(name = "Diana", age = 23)
    Annotated() throws NoSuchMethodException {
        Constructor<Annotated> constructor = Annotated.class.getDeclaredConstructor();
        CustomAnnotation customAnnotation = constructor.getAnnotation(CustomAnnotation.class);
        name = customAnnotation.name();
        age = customAnnotation.age();
    }

    @Override
    public String toString() {
        return "Annotated{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
