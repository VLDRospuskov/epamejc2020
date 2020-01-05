package main.homeworks.hw2;

public class Main {

    public static void main(String[] args) {

        MutableAge antonAge = new MutableAge();
        antonAge.setDay(25);
        antonAge.setMonth(6);
        antonAge.setYear(1993);
        ImmutableClassStudent anton = new ImmutableClassStudent(1, "Anton", antonAge);

        System.out.println("Anton's birth year befor modification: " + anton.getAge().getYear()); //1993

        antonAge.setYear(1976);

        System.out.println("Anton's birth year after modification: " + anton.getAge().getYear()); //1993 - immutable
        System.out.println("Anton's id is " + anton.getId());

        MutableAge aliceAge = new MutableAge();
        aliceAge.setDay(76); //There will be two messages about day input rules: it have to be between 1 and 31
        aliceAge.setMonth(8);
        aliceAge.setYear(1996);
        ImmutableClassStudent alice = new ImmutableClassStudent(2, "Alice", aliceAge);

        System.out.println("Alice's id is " + alice.getId() + "\nAlice's birthday is on " +
                alice.getAge().getDay() + "." + alice.getAge().getMonth() + "." + alice.getAge().getYear());

    }
}
