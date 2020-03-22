package homework.homework8.streamAPI;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static homework.homework8.streamAPI.GenerateData.getEmployees;
import static org.junit.Assert.assertEquals;

public class StreamOperationsTest {

    private StreamOperations streamOperations;
    private List<Employee> employees;

    @Before
    public void setup() {
        streamOperations = new StreamOperations();
        employees = getEmployees();
    }

    @Test
    public void findPersonsEverWorkedInEpam() {
        List<Person> expectedPersons = Arrays.asList(
                employees.get(0).getPerson(),
                employees.get(1).getPerson(),
                employees.get(4).getPerson(),
                employees.get(5).getPerson()
        );

        assertEquals(expectedPersons, streamOperations.findPersonsEverWorkedInEpam());
    }

    @Test
    public void findPersonsBeganCareerInEpam() {
        List<Person> expectedPersons = Arrays.asList(
                employees.get(0).getPerson(),
                employees.get(1).getPerson(),
                employees.get(4).getPerson()
        );
        assertEquals(expectedPersons, streamOperations.findPersonsBeganCareerInEpam());

    }

    @Test
    public void findAllCompanies() {
        List<String> companies = Arrays.asList(
                "EPAM",
                "google",
                "yandex",
                "mail.ru",
                "T-Systems"
        );

        assertEquals(new HashSet<>(companies), streamOperations.findAllCompanies());
    }

    @Test
    public void findMinimalAgeOfEmployees() {
        assertEquals(Integer.valueOf(21), streamOperations.findMinimalAgeOfEmployees());
    }

    @Test
    public void calcAverageAgeOfEmployees() {
        assertEquals(Double.valueOf(202.0 / 6), streamOperations.calcAverageAgeOfEmployees());
    }

    @Test
    public void findPersonWithLongestFullName() {
        assertEquals(employees.get(1).getPerson(), streamOperations.findPersonWithLongestFullName());
    }

    @Test
    public void findEmployeeWithMaximumDurationAtOnePosition() {
        assertEquals(employees.get(4), streamOperations.findEmployeeWithMaximumDurationAtOnePosition());
    }
}