package homeworks.hw6;

import java.lang.reflect.Constructor;

//@Data
public class Person {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private String name;
    private Integer age;

    @InformationAnnotation
    public Person() {
        Class<Person> personClass = Person.class;
        Constructor[] constructors = personClass.getConstructors();
        InformationAnnotation annotation =
                                    (InformationAnnotation)constructors[0].getAnnotation(InformationAnnotation.class);
        this.name = annotation.name();
        this.age = annotation.age();
    }

}
