package homework.hw8;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {

    List<Person> findPersonsEverWorkedInEpam(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee
                        .getJobHistory()
                        .stream()
                        .anyMatch(jhe -> jhe.getCompany().equals("EPAM")))
                .map(Employee::getPerson).collect(Collectors.toList());
    }

    List<Person> findPersonsBeganCareerInEpam(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee
                        .getJobHistory()
                        .get(0)
                        .getCompany().equals("EPAM"))
                .map(Employee::getPerson)
                .collect(Collectors.toList());
    }

    Set<String> findAllCompanies(List<Employee> employees) {
        return employees.stream()
                .map(employee -> employee
                        .getJobHistory()
                        .stream()
                        .map(JobHistoryEntry::getCompany))
                .reduce(Stream::concat)
                .orElse(new ArrayList<String>().stream())
                .collect(Collectors.toSet());
    }

    Integer findMinimalAgeOfEmployees(List<Employee> employees) {
        return employees
                .stream()
                .map(employee -> employee.getPerson().getAge())
                .min(Integer::compareTo)
                .orElse(null);
    }


    Double calcAverageAgeOfEmployees(List<Employee> employees) {
        return employees
                .stream()
                .mapToDouble(employee -> (double) employee.getPerson().getAge())
                .average()
                .orElse(0);
    }

    Person findPersonWithLongestFullName(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getPerson)
                .reduce((p1, p2) ->
                        p1.getFirstName().length() + p1.getLastName().length() >
                                p2.getFirstName().length() + p2.getLastName().length()
                                ? p1 : p2)
                .orElse(null);
    }

    Employee findEmployeeWithMaximumDurationAtOnePosition(List<Employee> employees) {
        return employees.stream()
                .reduce((e1, e2) ->
                        e1.getJobHistory().stream()
                                .map(JobHistoryEntry::getDuration)
                                .max(Integer::compareTo).orElse(0) >
                                e2.getJobHistory().stream()
                                        .map(JobHistoryEntry::getDuration)
                                        .max(Integer::compareTo).orElse(0)
                                ? e1 : e2)
                .orElse(null);
    }
}
