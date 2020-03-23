package lessons.java.lesson21.example7;

public class Main {

    public static void main(String[] args) {
        System.out.println(Day.MONDAY.ordinal()); // 1
        System.out.println(" " + Day.valueOf("THURDSAY".toUpperCase()).name()); // THURDSAY
    }

}

enum Day {SUNDAY, MONDAY, TUESDAY, WENDSDAY, THURDSAY, FRIDAY, SATURDAY, thurdsay}