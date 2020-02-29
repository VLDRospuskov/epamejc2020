package homeworks.HW8_functionalAndStream.streamOperations;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobHistoryEntry {

    private final int duration;
    private final String position;
    private final String company;

}