package homeworks.java.Java8.part2;

import homeworks.java.java8.part2.Employee;
import homeworks.java.java8.part2.GenerateData;
import homeworks.java.java8.part2.Person;
import homeworks.java.java8.part2.StreamOperations;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StreamOperationsTest {

    private StreamOperations streamOperations = new StreamOperations();
    private List<Employee> employees = GenerateData.getEmployees();

    @Test
    public void testFindPersonsEverWorkedInEpam() {

        List<Person> expected = new ArrayList<>();
        expected.add(employees.get(0).getPerson());
        expected.add(employees.get(1).getPerson());
        expected.add(employees.get(4).getPerson());
        expected.add(employees.get(5).getPerson());

        List<Person> actual = streamOperations.findPersonsEverWorkedInEpam();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFindAllCompanies() {

        Set<String> expected = new HashSet<>();
        expected.add("EPAM");
        expected.add("google");
        expected.add("yandex");
        expected.add("mail.ru");
        expected.add("T-Systems");

        Set<String> actual = streamOperations.findAllCompanies();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindMinimalAgeOfEmployees() {

        Integer expected = 21;

        Integer actual = streamOperations.findMinimalAgeOfEmployees();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testCalcAverageAgeOfEmployees() {

        Double expected = 33.666666666666664;

        Double actual = streamOperations.calcAverageAgeOfEmployees();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFindPersonWithLongestFullName() {

        Person expected = employees.get(1).getPerson();

        Person actual = streamOperations.findPersonWithLongestFullName();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFindEmployeeWithMaximumDurationAtOnePosition() {

        Employee expected = employees.get(4);

        Employee actual = streamOperations.findEmployeeWithMaximumDurationAtOnePosition();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFindPersonsBeganCareerInEpam() {

        List<Person> expected = new ArrayList<>();
        expected.add(employees.get(0).getPerson());
        expected.add(employees.get(1).getPerson());
        expected.add(employees.get(4).getPerson());

        List<Person> actual = streamOperations.findPersonsBeganCareerInEpam();

        Assert.assertEquals(expected, actual);

    }

}
