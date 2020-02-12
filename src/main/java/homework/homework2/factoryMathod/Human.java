package homework.homework2.factoryMathod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

interface Human {

    void showHuman ();
    default int getAgeFromDateOfBirth(Date date) {
        Date currentDate = new Date();
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1 = Integer.parseInt(formatter.format(date));
        int d2 = Integer.parseInt(formatter.format(currentDate));
        return (d2 - d1)/10000;
    }
}
