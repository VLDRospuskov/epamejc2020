package homeworks.homework8.stream_operations;

import java.util.*;
import java.util.stream.Collectors;

import static homeworks.homework8.stream_operations.GenerateData.*;


@SuppressWarnings({"unused"})
public class StreamOperations {

    void findPersonsEverWorkedInEpam() {
        List<Employee> employees = getEmployees();

        List<Person> personsEverWorkedInEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().stream()
                        .anyMatch(job -> job.getCompany().equals("EPAM")))
                .map(Employee::getPerson)
                .collect(Collectors.toList());

        System.out.println(personsEverWorkedInEpam.toString());
    }

    void findPersonsBeganCareerInEpam() {
        List<Employee> employees = getEmployees();

        List<Person> startedFromEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().get(0).getCompany().equals("EPAM"))
                .map(Employee::getPerson)
                .collect(Collectors.toList());

        System.out.println(startedFromEpam.toString());
    }

    void findAllCompanies() {
        List<Employee> employees = getEmployees();

        Set<String> companies = employees.stream()
                .flatMap(firms -> firms.getJobHistory().stream().map(JobHistoryEntry::getCompany))
                .collect(Collectors.toSet());

        System.out.println(companies.toString());
    }

    void findMinimalAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Integer minimalAge = employees.stream()
                .min(Comparator.comparingInt(employee -> employee.getPerson().getAge()))
                .map(employee -> employee.getPerson().getAge())
                .get();

        System.out.println("Minimal age is " + minimalAge);
    }

    void calcAverageAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Double expected = employees.stream()
                .mapToDouble(employee -> employee.getPerson().getAge())
                .average()
                .orElseThrow(RuntimeException::new);

        System.out.println("Average age is " + expected);
    }

    void findPersonWithLongestFullName() {
        List<Employee> employees = getEmployees();

        Person expected = employees.stream()
                .max(Comparator.comparingInt(employee -> employee.getPerson().getFirstName().length()
                                                       + employee.getPerson().getLastName().length()))
                .map(Employee::getPerson)
                .get();

        System.out.println("Longest full name " + expected.toString());
    }

    void findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = getEmployees();

        Employee expected = employees.stream()
                .max(Comparator.comparingInt(employee -> employee.getJobHistory().stream()
                        .map(JobHistoryEntry::getDuration).max(Integer::compareTo).orElseThrow(RuntimeException::new)))
                .orElseThrow(RuntimeException::new);

        System.out.println("Max duration employee " + expected.toString());
    }

}
