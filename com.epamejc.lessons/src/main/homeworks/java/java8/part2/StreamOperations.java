package homeworks.java.java8.part2;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static homeworks.java.java8.part2.GenerateData.getEmployees;

public class StreamOperations {

    List<Person> findPersonsEverWorkedInEpam() {
        List<Employee> employees = getEmployees();

        return employees.stream()
                .filter(employee -> employee.getJobHistory()
                        .stream()
                        .anyMatch(jobHistory -> jobHistory.getCompany().equalsIgnoreCase("EPAM")))
                .map(Employee::getPerson)
                .collect(Collectors.toList());

    }

    List<Person> findPersonsBeganCareerInEpam() {
        List<Employee> employees = getEmployees();

        return employees.stream()
                .filter(employee -> employee.getJobHistory().get(0).getCompany().equalsIgnoreCase("EPAM"))
                .map(Employee::getPerson)
                .collect(Collectors.toList());

    }

    Set<String> findAllCompanies() {
        List<Employee> employees = getEmployees();

        return employees.stream()
                .map(Employee::getJobHistory)
                .flatMap(Collection::stream)
                .map(JobHistoryEntry::getCompany)
                .collect(Collectors.toSet());

    }

    Integer findMinimalAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        return employees.stream()
                .map(Employee::getPerson)
                .map(Person::getAge)
                .min(Integer::compareTo)
                .orElse(0);

    }

    Double calcAverageAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        return employees.stream()
                .map(Employee::getPerson)
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.);

    }

    Person findPersonWithLongestFullName() {
        List<Employee> employees = getEmployees();

        return employees.stream()
                .map(Employee::getPerson)
                .reduce((person1, person2) ->
                        person1.getFirstName().length() + person1.getLastName().length() >
                                person2.getFirstName().length() + person2.getLastName().length() ? person1 : person2)
                .orElseThrow(() -> new RuntimeException("There are no employees in the list"));

    }

    Employee findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = getEmployees();

        return employees.stream()
                .max(Comparator.comparingInt(this::getMaxDuration))
                .orElseThrow(() -> new RuntimeException("There are no employees in the list"));

    }

    private Integer getMaxDuration(Employee employee) {

        return employee.getJobHistory().stream()
                .map(JobHistoryEntry::getDuration)
                .max(Integer::compareTo)
                .orElse(0);

    }
}