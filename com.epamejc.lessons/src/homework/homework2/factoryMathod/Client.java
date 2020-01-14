package homework.homework2.factoryMathod;

import java.util.Calendar;
import java.util.Date;

class Client {
    public static void main(String[] args) {

        HumanFabric humanFabric = new HumanFabric();
        Calendar calendar = Calendar.getInstance();
        calendar.set(1997, Calendar.MARCH, 28);
        Date date = calendar.getTime();

        Male male = (Male) humanFabric.getHuman(date, Gender.MALE, "Oleg");
        male.showHuman();

        Female female = (Female) humanFabric.getHuman(date, Gender.FEMALE, "Olega");
        female.showHuman();

        Undefined undefined = (Undefined) humanFabric.getHuman(date, Gender.UNDEFINED, "Olego");
        undefined.showHuman();
    }
}
