package main.homeworks.java.hw2;

import java.util.Iterator;

import static main.homeworks.java.hw2.StudentCreatorClass.getIdTable;
import static main.homeworks.java.hw2.StudentCreatorClass.setIdTable;

/**
 * Here is an immutable class represents student. Student has a field which is an instance of a mutable class -
- age (of a MutableAGe class).
 * To prevent the mutability of the age field on immutable instance of student
a clone instance of passed argument of Age was used.*/

public final class ImmutableClassStudent {

    private final int ID;
    private final String NAME;
    private final MutableAge AGE;

    public ImmutableClassStudent(int id, String name, MutableAge age) {

        checkID(id);
        this.ID = id;
        this.NAME = name;
        MutableAge cloneAge = new MutableAge();
        cloneAge.setDay(age.getDay());
        cloneAge.setMonth(age.getMonth());
        cloneAge.setYear(age.getYear());
        this.AGE = cloneAge;

    }

    private void checkID(int id) {
        Iterator<Integer> iterator = getIdTable().iterator();
        while (iterator.hasNext()) {
            if (getIdTable().contains(id)) throw new RuntimeException("Id has to be unique");
        }
        setIdTable(id);
    }

    public int getId() {
        return ID;
    }

    public String getName() {
        return NAME;
    }

    public MutableAge getAge() {
        return AGE;
    }
}
