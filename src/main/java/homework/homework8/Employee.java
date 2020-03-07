package homework.homework8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Employee {

    private final Person person;
    private final List<JobHistoryEntry> jobHistory;
}