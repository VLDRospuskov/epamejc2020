package homework.homework8;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

import static homework.homework8.GenerateData.getEmployees;

public class StreamOperationsTest {

    private StreamOperations streamOperations = new StreamOperations();
    private List<Employee> employees = getEmployees();

    @Test
    public void findPersonsEverWorkedInEpam() {
        List<Person> workedInEPAM = new ArrayList<>();
        workedInEPAM.add(employees.get(0).getPerson());
        workedInEPAM.add(employees.get(1).getPerson());
        workedInEPAM.add(employees.get(4).getPerson());
        workedInEPAM.add(employees.get(5).getPerson());

        assertEquals(workedInEPAM,
                streamOperations.findPersonsEverWorkedInEpam(employees));
    }

    @Test
    public void findPersonsBeganCareerInEpam() {
        List<Person> beganCareerAtEPAM = Arrays.asList(
                employees.get(0).getPerson(),
                employees.get(1).getPerson(),
                employees.get(4).getPerson()
        );

        assertEquals(beganCareerAtEPAM,
                streamOperations.findPersonsBeganCareerInEpam(employees));
    }

    @Test
    public void findAllCompanies() {
        Set<String> companies = new HashSet<>(Arrays.asList("EPAM", "google", "yandex", "mail.ru", "T-Systems"));

        assertEquals(companies,
                streamOperations.findAllCompanies(employees));
    }

    @Test
    public void findMinimalAgeOfEmployees() {
        Integer minimalAge = 21;

        assertEquals(minimalAge,
                streamOperations.findMinimalAgeOfEmployees(employees));
    }

    @Test
    public void calcAverageAgeOfEmployees() {
        Double averageAge = (double) (30 + 28 + 40 + 21 + 50 + 33) / 6.0;

        assertEquals(averageAge,
                streamOperations.calcAverageAgeOfEmployees(employees));
    }

    @Test
    public void findPersonWithLongestFullName() {
        Person longestFullNamePerson = employees.get(1).getPerson();

        assertEquals(longestFullNamePerson,
                streamOperations.findPersonWithLongestFullName(employees));
    }

    @Test
    public void findEmployeeWithMaximumDurationAtOnePosition() {
        Employee maximumWorkAtASinglePositionDurationPerson = employees.get(4);

        assertEquals(maximumWorkAtASinglePositionDurationPerson,
                streamOperations.findEmployeeWithMaximumDurationAtOnePosition(employees));
    }

}

