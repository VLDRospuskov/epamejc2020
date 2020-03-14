package homework.homework8.streamAPI;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static homework.homework8.streamAPI.GenerateData.getEmployees;

public class StreamOperations {

    List<Person> findPersonsEverWorkedInEpam() {
        List<Employee> employees = getEmployees();

        return employees.stream()
                .filter(employee -> employee.getJobHistory()
                        .stream()
                        .anyMatch(history -> history.getCompany().equals("EPAM"))
                )
                .map(Employee::getPerson)
                .collect(Collectors.toList());
    }

    List<Person> findPersonsBeganCareerInEpam() {
        List<Employee> employees = getEmployees();

        return employees.stream()
                .filter(employee -> employee.getJobHistory().get(0).getCompany().equals("EPAM"))
                .map(Employee::getPerson)
                .collect(Collectors.toList());
    }

    Set<String> findAllCompanies() {
        List<Employee> employees = getEmployees();

        return employees.stream()
                .map(Employee::getJobHistory)
                .flatMap(histories -> histories.stream())
                .map(JobHistoryEntry::getCompany)
                .collect(Collectors.toSet());
    }

    Integer findMinimalAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        return employees.stream()
                .map(Employee::getPerson)
                .map(Person::getAge)
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalStateException("Cant't find employee with minimal age"));
    }

    Double calcAverageAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        return employees.stream()
                .map(Employee::getPerson)
                .mapToInt(Person::getAge)
                .average()
                .orElseThrow(() -> new IllegalStateException("Cant't calculate average age of employees"));
    }

    Person findPersonWithLongestFullName() {
        List<Employee> employees = getEmployees();

        return employees.stream()
                .map(Employee::getPerson)
                .reduce((person1, person2) -> (person1.getLastName() + person1.getFirstName()).length() >
                        (person2.getLastName() + person2.getFirstName()).length() ? person1 : person2)
                .orElseThrow(() -> new IllegalStateException("Cant't find person with longest full name"));
    }

    Employee findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = getEmployees();

        return employees.stream()
                .reduce((employee1, employee2) -> getMaxDuration(employee1) > getMaxDuration(employee2) ?
                        employee1 : employee2)
                .orElseThrow(
                        () -> new IllegalStateException("Cant't find employee with maximum duration at one position")
                );
    }

    private int getMaxDuration(Employee employee) {
        return employee.getJobHistory()
                .stream()
                .mapToInt(JobHistoryEntry::getDuration)
                .max()
                .orElseThrow(() -> new IllegalStateException("Cant't find job with maximum duration"));
    }
}
