package homeworks.homework8_stream;

import org.junit.Before;
import org.junit.Test;

import java.util.*;


import static org.junit.Assert.*;

public class StreamOperationsTest {

    private StreamOperations operations;

    @Before
    public void setUp() {
        operations = new StreamOperations();
    }

    @Test
    public void findPersonsEverWorkedInEpam() {
        List<Person> expected = Arrays.asList(
                new Person("Иван", "Мельников", 30),
                new Person("Александр", "Дементьев", 28),
                new Person("Игорь", "Толмачёв", 50),
                new Person("Иван", "Александров", 33)
        );
        List<Person> actual = operations.findPersonsEverWorkedInEpam();
        assertEquals(expected, actual);
    }

    @Test
    public void findPersonsBeganCareerInEpam() {
        List<Person> expected = Arrays.asList(
                new Person("Иван", "Мельников", 30),
                new Person("Александр", "Дементьев", 28),
                new Person("Игорь", "Толмачёв", 50)

        );
        List<Person> actual = operations.findPersonsBeganCareerInEpam();
        assertEquals(expected, actual);
    }

    @Test
    public void findAllCompanies() {
        Set<String> expected = new HashSet<>();
        expected.add("yandex");
        expected.add("EPAM");
        expected.add("T-Systems");
        expected.add("google");
        expected.add("mail.ru");
        Set<String> actual = operations.findAllCompanies();
        assertEquals(expected, actual);
    }

    @Test
    public void findMinimalAgeOfEmployees() {
        Integer ageExpected = 21;
        Integer ageActual = operations.findMinimalAgeOfEmployees();
        assertEquals(ageExpected, ageActual);
    }

    @Test
    public void calcAverageAgeOfEmployees() {
        Double ageExpected = 33.7;
        Double ageActual = operations.calcAverageAgeOfEmployees();
        assertEquals(ageExpected,ageActual,0.1);
    }

    @Test
    public void findPersonWithLongestFullName() {
        Person personExpected = new Person("Александр", "Дементьев", 28);
        Person personActual = operations.findPersonWithLongestFullName();
        assertEquals(personExpected,personActual);
    }

    @Test
    public void findEmployeeWithMaximumDurationAtOnePosition() {
        Employee employeeExpected = new Employee(
                new Person("Игорь", "Толмачёв", 50),
                Arrays.asList(
                        new JobHistoryEntry(5, "tester", "EPAM"),
                        new JobHistoryEntry(6, "QA", "EPAM")
                ));
        Employee employeeActual = operations.findEmployeeWithMaximumDurationAtOnePosition();
        assertEquals(employeeExpected,employeeActual);
    }
}