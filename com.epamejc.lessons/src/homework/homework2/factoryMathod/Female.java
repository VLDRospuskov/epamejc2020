package homework.homework2.factoryMathod;

import java.util.Date;

class Female implements Human {

    final Date dateOfBirth;
    String name;
    Gender gender = Gender.FEMALE;

    Female (Date dateOfBirth, String name) {
        this.dateOfBirth = dateOfBirth;
        this.name = name;
    }

    int getAge() {
        return getAge(this.dateOfBirth);
    }


    Gender getGender() {
        return this.gender;
    }


    String getName() {
        return this.name;
    }

    @Override
    public void showHuman() {
        System.out.println();
        System.out.println("Name is " + this.getName());
        System.out.println("Gander is " + this.getGender().toString());
        System.out.println("Age is " + this.getAge());
        System.out.println();
    }
}
