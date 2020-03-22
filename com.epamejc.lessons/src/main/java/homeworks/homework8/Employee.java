package homeworks.homework8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Employee {
    
    private final Person person;
    private final List<JobHistoryEntry> jobHistory;
    
    public Person getPerson() {
        return person;
    }
    
    public List<JobHistoryEntry> getJobHistory() {
        return jobHistory;
    }
    
}