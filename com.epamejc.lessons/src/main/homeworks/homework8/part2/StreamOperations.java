package main.homeworks.homework8.part2;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static main.homeworks.homework8.part2.GenerateData.getEmployees;

@SuppressWarnings({"unused"})
public class StreamOperations {

    void findPersonsEverWorkedInEpam() {
        List<Employee> employees = getEmployees();
        List<Person> personsEverWorkedInEpam = null;
        personsEverWorkedInEpam = employees.stream()
                .filter(employee -> employee.getJobHistory()
                        .stream()
                        .anyMatch(company -> company.getCompany().equals("EPAM")))
                .map(Employee::getPerson)
                .collect(Collectors.toList());
        System.out.println(personsEverWorkedInEpam);
    }

    void findPersonsBeganCareerInEpam() {
        List<Employee> employees = getEmployees();
        List<Person> startedFromEpam = null;
        startedFromEpam = employees.stream()
                .filter(employee -> employee
                        .getJobHistory()
                        .get(0)
                        .getCompany()
                        .equals("EPAM"))
                .map(Employee::getPerson)
                .collect(Collectors.toList());
        System.out.println(startedFromEpam);
    }

    void findAllCompanies() {
        List<Employee> employees = getEmployees();
        Set<String> companies = null;
        companies = employees.stream()
                .map(Employee::getJobHistory)
                .flatMap(x -> x.stream().map(JobHistoryEntry::getCompany))
                .collect(Collectors.toSet());
        System.out.println(companies);
    }

    void findMinimalAgeOfEmployees() {
        List<Employee> employees = getEmployees();
        Integer minimalAge = null;
        minimalAge = employees.stream()
                .map(Employee::getPerson)
                .map(Person::getAge)
                .min(Integer::compare)
                .get();
        System.out.println(minimalAge);
    }

    void calcAverageAgeOfEmployees() {
        List<Employee> employees = getEmployees();
        Double expected = null;
        expected = employees.stream()
                .map(Employee::getPerson)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
        System.out.println(expected);

    }

    void findPersonWithLongestFullName() {
        List<Employee> employees = getEmployees();
        Person expected = null;
        expected = employees.stream()
                .map(Employee::getPerson)
                .reduce((a, b) -> a.getLastName().length() >= b.getLastName().length() ? a : b)
                .get();
        System.out.println(expected);
    }

    void findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = getEmployees();
        Employee expected = null;
        expected = employees.stream()
                .reduce((a, b) ->
                        a.getJobHistory().stream()
                                .map(JobHistoryEntry::getDuration).max(Integer::compare).get() >=
                                b.getJobHistory().stream()
                                        .map(JobHistoryEntry::getDuration).max(Integer::compare).get() ? a : b)
                .get();
        System.out.println(expected);
    }

}