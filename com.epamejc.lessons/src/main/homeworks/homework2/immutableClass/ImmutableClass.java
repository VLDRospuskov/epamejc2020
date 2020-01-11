package main.homeworks.homework2.immutableClass;
import java.util.Date;

class ImmutableClassPerson {
    private final String name;
    private final int age;
    private final Date dateOfBirth;
    private final double height;

    public ImmutableClassPerson(String name, int age, double height, Date dateOfBirth) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getDateOfBirth() {
        return (Date)dateOfBirth.clone();
    }

    public double getHeight() {
        return height;
    }
}
