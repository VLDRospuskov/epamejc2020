package homeworks.homework2.factoryMathod;

import lombok.Getter;

import java.util.Date;

@Getter
class Male implements Human {
    final Date dateOfBirth;
    String name;
    Gender gender = Gender.MALE;

    Male (Date dateOfBirth, String name) {
        this.dateOfBirth = dateOfBirth;
        this.name = name;
    }

    int getAge() {
        return getAgeFromDateOfBirth(this.dateOfBirth);
    }

    @Override
    public void showHuman() {
        System.out.println("\nName is " + this.getName());
        System.out.println("Gander is " + this.getGender().toString());
        System.out.println("Age is " + this.getAge() + "\n");
    }
}
