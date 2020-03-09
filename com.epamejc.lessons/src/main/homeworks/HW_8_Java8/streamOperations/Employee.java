package homeworks.HW_8_Java8.streamOperations;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Employee {

    private final Person person;
    private final List<JobHistoryEntry> jobHistory;

}
