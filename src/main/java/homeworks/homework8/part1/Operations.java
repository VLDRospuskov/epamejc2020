package homeworks.homework8.part1;

import java.util.List;
import java.util.Random;

import static homeworks.homework8.part1.GenerateData.getData;

public class Operations {

    public void operate () {

        DataToValidate dataToValidate = getData(() ->
                new Random().ints(0, (100 + 1))
                .findFirst()
                .orElse(0)
        );

        List<Integer> data = dataToValidate.getDataToValidate();
        data.forEach(number -> System.out.println(" " + number));

        System.out.println("_____________________________________");

        ValidateData validateData = new ValidateData();
        List<Integer> newData = validateData.showValidatedData(data, number -> 0);

        newData.forEach(number -> System.out.println(" " + number));
    }
}
