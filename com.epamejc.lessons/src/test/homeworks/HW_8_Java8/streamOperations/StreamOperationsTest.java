package homeworks.HW_8_Java8.streamOperations;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static homeworks.HW_8_Java8.streamOperations.GenerateData.getEmployees;
import static org.junit.Assert.*;

public class StreamOperationsTest {
    private List<Employee> employees;
    private StreamOperations streamOperations;

    @Before
    public void setUp() {
        employees = getEmployees();
        streamOperations = new StreamOperations();
    }

    @Test
    public void findPersonsEverWorkedInEpamTest() {
        List<Person> expected = new ArrayList<>();
        expected.add(employees.get(0).getPerson());
        expected.add(employees.get(1).getPerson());
        expected.add(employees.get(4).getPerson());
        expected.add(employees.get(5).getPerson());

        List<Person> actual = streamOperations.findPersonsEverWorkedInEpam();

        assertEquals(actual, expected);
    }

    @Test
    public void findPersonsBeganCareerInEpamTest() {
        List<Person> expected = new ArrayList<>();
        expected.add(employees.get(0).getPerson());
        expected.add(employees.get(1).getPerson());
        expected.add(employees.get(4).getPerson());

        List<Person> actual = streamOperations.findPersonsBeganCareerInEpam();

        assertEquals(actual, expected);
    }

    @Test
    public void findAllCompaniesTest() {
        Set<String> expected = new HashSet<>();
        expected.add("EPAM");
        expected.add("google");
        expected.add("yandex");
        expected.add("mail.ru");
        expected.add("T-Systems");

        Set<String> actual = streamOperations.findAllCompanies();

        assertEquals(expected, actual);
    }

    @Test
    public void findMinimalAgeOfEmployeesTest() {
        Integer expected = 21;
        Integer actual = streamOperations.findMinimalAgeOfEmployees();

        assertEquals(expected, actual);
    }

    @Test
    public void calcAverageAgeOfEmployeesTest() {
        double expected = 33.66;
        double actual = streamOperations.calcAverageAgeOfEmployees();

        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void findPersonWithLongestFullNameTest() {
        Person expected = employees.get(1).getPerson();
        Person actual = streamOperations.findPersonWithLongestFullName();

        assertEquals(expected, actual);
    }

    @Test
    public void findEmployeeWithMaximumDurationAtOnePositionTest() {
        Employee expected = employees.get(4);
        Employee actual = streamOperations.findEmployeeWithMaximumDurationAtOnePosition();

        assertEquals(expected, actual);
    }
}