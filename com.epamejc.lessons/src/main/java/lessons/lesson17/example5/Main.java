package lessons.lesson17.example5;

import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    
    public static void main(String[] args) {
        Date date = new Date(34567890);
        System.out.println(date);
        Calendar calendar = new GregorianCalendar();
        System.out.println(calendar);
        
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalTime localTime;
        LocalDate localDate;
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        
        Instant now1 = Instant.now();
        System.out.println(now1);
    }
    
}

class User {
    
    private int id;
    private Instant instant;
    
}
