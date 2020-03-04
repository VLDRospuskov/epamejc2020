package homeworks.homework8.part1;

import java.util.List;
import java.util.stream.Collectors;

public class ValidateData {



    public List<Integer> showValidatedData (List<Integer> data , Validator<? extends Integer> validator) {

        return data.stream()
                .map(number -> number < 500 ? validator.validate(number) : number)
                .collect(Collectors.toList());
    }
}
