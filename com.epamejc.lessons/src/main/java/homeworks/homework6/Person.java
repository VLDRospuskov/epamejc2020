package homeworks.homework6;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Constructor;

@Getter
@Setter
public class Person {
    
    private String name;
    private int age;
    
    @CustomAnnotation(name = "Barsik", age = 6)
    public Person() {
        Constructor<Person> personConstructor = null;
        try {
            personConstructor = Person.class.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        assert personConstructor != null;
        CustomAnnotation customAnnotation = personConstructor.getAnnotation(CustomAnnotation.class);
        this.name = customAnnotation.name();
        this.age = customAnnotation.age();
    }
    
    public String getStr() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    @Override
    public String toString() {
        return "Person[" + "name: " + name + ", age = " + age + "]";
    }
    
}
