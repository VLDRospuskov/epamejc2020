package main.homeworks.hw2;

public final class ImmutableClassStudent {

    private final int ID;
    private final String NAME;
    private final MutableAge AGE;

    public ImmutableClassStudent(int id, String name, MutableAge age) {

        this.ID = id;
        this.NAME = name;
        MutableAge cloneAge = new MutableAge(); //to keep this class immutable we use clone instance of age argument
        cloneAge.setDay(age.getDay());
        cloneAge.setMonth(age.getMonth());
        cloneAge.setYear(age.getYear());
        this.AGE = cloneAge;

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
