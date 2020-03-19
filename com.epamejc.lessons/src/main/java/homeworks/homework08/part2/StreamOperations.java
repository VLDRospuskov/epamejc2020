package homeworks.homework08.part2;

import lombok.SneakyThrows;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static homeworks.homework08.part2.GenerateData.getEmployees;

@SuppressWarnings({"unused"})
public class StreamOperations {

    public List<Person> findPersonsEverWorkedInEpam() {
        List<Employee> employees = getEmployees();

        List<Person> personsEverWorkedInEpam;

        personsEverWorkedInEpam = employees.stream()
                .filter(employee -> employee.getJobHistory()
                        .stream()
                        .anyMatch(jobHistoryEntry -> jobHistoryEntry
                                .getCompany()
                                .equals("EPAM")))
                .map(Employee::getPerson)
                .collect(Collectors.toList());

        return personsEverWorkedInEpam;
    }

    public List<Person> findPersonsBeganCareerInEpam() {
        List<Employee> employees = getEmployees();

        List<Person> startedFromEpam;

        startedFromEpam = employees.stream()
                .filter(employee -> employee.getJobHistory()
                        .get(0)
                        .getCompany()
                        .equals("EPAM"))
                .map(Employee::getPerson)
                .collect(Collectors.toList());

        return startedFromEpam;
    }

    public Set<String> findAllCompanies() {
        List<Employee> employees = getEmployees();

        Set<String> companies;

        companies = employees
                .stream()
                .flatMap(employee -> employee
                        .getJobHistory()
                        .stream())
                .map(JobHistoryEntry::getCompany)
                .collect(Collectors.toSet());

        return companies;
    }

    public Integer findMinimalAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Integer minimalAge;

        minimalAge = employees.stream()
                .map(employee -> employee.getPerson().getAge())
                .min(Integer::compareTo)
                .orElse(-1);

        return minimalAge;
    }

    public Double calcAverageAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Double averageAge;

        averageAge = employees.stream()
                .mapToDouble(employee -> employee.getPerson().getAge())
                .average()
                .orElse(-1);

        return averageAge;
    }

    @SneakyThrows
    public Person findPersonWithLongestFullName() {
        List<Employee> employees = getEmployees();

        Person personWithLongestFullName;

        personWithLongestFullName = employees.stream()
                .map(Employee::getPerson)
                .reduce((left, right) ->
                        (left.getFirstName() + left.getLastName()).length() >
                                (right.getFirstName() + right.getLastName()).length() ? left : right)
                .orElseThrow(() -> new Exception("No employees"));

        return personWithLongestFullName;
    }

    @SneakyThrows
    public Employee findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = getEmployees();

        Employee employeeWithMaximumDurationAtOnePosition;

        employeeWithMaximumDurationAtOnePosition = employees.stream()
                .reduce((empl1, empl2) ->
                        empl1.getJobHistory().stream()
                                .mapToInt(JobHistoryEntry::getDuration).max().orElse(-1)
                        > empl2.getJobHistory().stream()
                                .mapToInt(JobHistoryEntry::getDuration).max().orElse(-1)
                        ? empl1 : empl2)
                .orElseThrow(() -> new Exception("No employees"));

        return employeeWithMaximumDurationAtOnePosition;
    }

}