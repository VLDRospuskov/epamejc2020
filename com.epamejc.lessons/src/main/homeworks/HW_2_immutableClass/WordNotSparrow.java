package homeworks.HW_2_immutableClass;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class WordNotSparrow {

    private final String word;
    private final String person;

}