package homeworks.homework6;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Constructor;
import java.util.Objects;

@Getter
@Setter
public class Person {
    
    private String name;
    private int age;
    
    @CustomAnnotation(name = "Barsik", age = 6)
    public Person() {
        CustomAnnotation customAnnotation = getCustomAnnotation();
        this.name = customAnnotation.name();
        this.age = customAnnotation.age();
    }
    
    private CustomAnnotation getCustomAnnotation() {
        Constructor<Person> personConstructor = null;
        try {
            personConstructor = Person.class.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return Objects.requireNonNull(personConstructor).getAnnotation(CustomAnnotation.class);
        
    }
    
    public String getStr() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    @Override
    public String toString() {
        return "Player[" + "name: " + name + ", age = " + age + "]";
    }
    
}
