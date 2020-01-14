package homework.homework2.factoryMathod;

import java.util.Date;

class HumanFabric {

    public Human getHuman (Date dateOfBirth, Gender gender, String name) {
        if (gender == Gender.MALE) {
            return new Male(dateOfBirth, name);
        } else if (gender == Gender.FEMALE) {
            return new Female(dateOfBirth, name);
        } else if (gender == Gender.UNDEFINED) {
            return new Undefined(dateOfBirth, name);
        } else {
            return null;
        }

    }
}
