package homework8.part2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
class Employee {

    private final Person person;
    private final List<JobHistoryEntry> jobHistory;

}