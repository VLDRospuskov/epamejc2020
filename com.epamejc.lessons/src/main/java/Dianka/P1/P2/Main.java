package Dianka.P1.P2;


import java.time.*;

public class Main {
    public static void main(String[] args) {
        LocalDate montyPythonDay = LocalDate.of(2017, Month.MAY, 10);
        LocalDate aprilFools = LocalDate.of(2018, Month.APRIL, 1);
        Duration duration = Duration.ofDays(1);
        LocalDate result = montyPythonDay.minus(duration);
        System.out.println(result + " " + aprilFools.isBefore(result));
    }
}