package Home_works.HW_8_part_2;

import lombok.Data;

import java.util.List;

@Data
public class Employee {

    private Person person;
    private  List<JobHistoryEntry> jobHistory;

    public Employee(Person person, List<JobHistoryEntry> jobHistory) {
        this.person = person;
        this.jobHistory = jobHistory;
    }

    public Person getPerson() {
        return person;
    }

    public List<JobHistoryEntry> getJobHistory() {
        return jobHistory;
    }
}
