package homeworks.homework08;

import homeworks.homework08.part2.Employee;
import homeworks.homework08.part2.Person;
import homeworks.homework08.part2.StreamOperations;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static homeworks.homework08.part2.GenerateData.getEmployees;

public class StreamTasksTest {
    List<Employee> employees = getEmployees();
    StreamOperations streamOperations = new StreamOperations();


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
    public void testFindPersonsBeganCareerInEpam() {
        List<Person> expected = new ArrayList<>();
        expected.add(employees.get(0).getPerson());
        expected.add(employees.get(1).getPerson());
        expected.add(employees.get(4).getPerson());

        List<Person> actual = streamOperations.findPersonsEverWorkedInEpam();

        Assert.assertEquals(expected, actual);
    }

}
