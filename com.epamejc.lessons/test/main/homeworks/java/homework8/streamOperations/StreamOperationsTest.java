package main.homeworks.java.homework8.streamOperations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static main.homeworks.java.homework8.streamOperations.GenerateData.getEmployees;
import static org.junit.Assert.*;

public class StreamOperationsTest {

    private StreamOperations streamOperations = new StreamOperations();
    private List<Employee> employees = getEmployees();

    @Test
    public void findPersonsEverWorkedInEpam() {
        List<Person> expected = new ArrayList<>();
        expected.add(employees.get(0).getPerson());
        expected.add(employees.get(1).getPerson());
        expected.add(employees.get(4).getPerson());
        expected.add(employees.get(5).getPerson());
        List<Person> actual = streamOperations.findPersonsEverWorkedInEpam();

        assertEquals(expected, actual);
    }

    @Test
    public void findPersonsBeganCareerInEpam() {
        List<Person> expected = new ArrayList<>();
        expected.add(employees.get(0).getPerson());
        expected.add(employees.get(1).getPerson());
        expected.add(employees.get(4).getPerson());
        List<Person> actual = streamOperations.findPersonsBeganCareerInEpam();

        assertEquals(expected, actual);
    }

    @Test
    public void findAllCompanies() {
        Set<String> expected = new HashSet<>();
        expected.add("EPAM");
        expected.add("yandex");
        expected.add("google");
        expected.add("mail.ru");
        expected.add("T-Systems");
        Set<String> actual = streamOperations.findAllCompanies();

        assertEquals(expected, actual);
    }

    @Test
    public void findMinimalAgeOfEmployees() {
        Integer expected = 21;
        Integer actual = streamOperations.findMinimalAgeOfEmployees();

        assertEquals(expected, actual);
    }

    @Test
    public void calcAverageAgeOfEmployees() {
        Double expected = 202 / 6.0;
        Double actual = streamOperations.calcAverageAgeOfEmployees();

        assertEquals(expected, actual);
    }

    @Test
    public void findPersonWithLongestFullName() {
        Person expected = employees.get(1).getPerson();
        Person actual = streamOperations.findPersonWithLongestFullName();

        assertEquals(expected, actual);
    }

    @Test
    public void findEmployeeWithMaximumDurationAtOnePosition() {
        Employee expected = employees.get(4);
        Employee actual = streamOperations.findEmployeeWithMaximumDurationAtOnePosition();

        assertEquals(expected, actual);
    }
}