package lessons.java.lesson21.example16;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
//        LocalDate.of();
        LocalDate now = LocalDate.now(); // immutable
//        now.setDay(30);
        LocalDate localDate = now.plusYears(-10);
        System.out.println(localDate);
    }

}
