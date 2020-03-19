package homeworks.homework08;

import homeworks.homework08.part2.Employee;
import homeworks.homework08.part2.JobHistoryEntry;
import homeworks.homework08.part2.Person;
import homeworks.homework08.part2.StreamOperations;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static homeworks.homework08.part2.GenerateData.getEmployees;

public class StreamTasksTest {
    List<Employee> employees = getEmployees();
    StreamOperations streamOperations = new StreamOperations();


    @Test
    public void testFindPersonsEverWorkedInEpam() {
        List<Person> expected = new ArrayList<>();

        for (Employee employee : employees) {
            for (JobHistoryEntry jobHistoryEntry : employee.getJobHistory()) {
                if (jobHistoryEntry.getCompany().equals("EPAM")) {
                    expected.add(employee.getPerson());
                    break;
                }
            }
        }

        List<Person> actual = streamOperations.findPersonsEverWorkedInEpam();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindPersonsBeganCareerInEpam() {
        List<Person> expected = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getJobHistory().get(0).getCompany().equals("EPAM")) {
                expected.add(employee.getPerson());
            }
        }

        List<Person> actual = streamOperations.findPersonsBeganCareerInEpam();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindAllCompanies() {
        Set<String> expected = new HashSet<>();
        for (Employee employee : employees) {
            for (JobHistoryEntry jobHistoryEntry : employee.getJobHistory()) {
                expected.add(jobHistoryEntry.getCompany());
            }
        }

        Set<String> actual = streamOperations.findAllCompanies();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindMinimalAgeOfEmployees() {
        int expected = Integer.MAX_VALUE;

        for (Employee employee : employees) {
            if (employee.getPerson().getAge() < expected) {
                expected = employee.getPerson().getAge();
            }
        }

        int actual = streamOperations.findMinimalAgeOfEmployees();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalcAverageAgeOfEmployees() {
        double expected = 0;
        for (Employee employee : employees) {
            expected += (double) employee.getPerson().getAge() / employees.size();
        }

        double actual = streamOperations.calcAverageAgeOfEmployees();

        Assert.assertEquals(expected, actual, 0.000001);
    }

    @Test
    public void testFindPersonWithLongestFullName() {
        Person expected = null;

        String longestName = "";
        for (Employee employee : employees) {
            String currentName = (employee.getPerson().getFirstName() + employee.getPerson().getLastName());
            if (currentName.length() > longestName.length()) {
                longestName = currentName;
                expected = employee.getPerson();
            }
        }

        Person actual = streamOperations.findPersonWithLongestFullName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindEmployeeWithMaximumDurationAtOnePosition() {
        Employee expected = null;

        int maxDuration = 0;
        for (Employee employee : employees) {
            for (JobHistoryEntry jobHistoryEntry : employee.getJobHistory()) {
                if (jobHistoryEntry.getDuration() > maxDuration) {
                    maxDuration = jobHistoryEntry.getDuration();
                    expected = employee;
                }
            }
        }

        Employee actual = streamOperations.findEmployeeWithMaximumDurationAtOnePosition();

        Assert.assertEquals(expected, actual);
    }


}
