package homeworks.homework8_stream;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobHistoryEntry {

    private final int duration;
    private final String position;
    private final String company;

}