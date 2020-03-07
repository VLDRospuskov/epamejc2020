package main.homeworks.java.homework8.streamOperations;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import static main.homeworks.java.homework8.streamOperations.GenerateData.getEmployees;


public class StreamOperations {

    List<Person> findPersonsEverWorkedInEpam() {
        List<Employee> employees = getEmployees();

        List<Person> personsEverWorkedInEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().stream()
                        .anyMatch(job -> job.getCompany().equals("EPAM")))
                .map(Employee::getPerson)
                .collect(Collectors.toList());
        return personsEverWorkedInEpam;
    }

    List<Person> findPersonsBeganCareerInEpam() {
        List<Employee> employees = getEmployees();

        List<Person> startedFromEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().stream()
                        .findFirst().get()
                        .getCompany().equals("EPAM"))
                .map(Employee::getPerson)
                .collect(Collectors.toList());
        return startedFromEpam;
    }

    Set<String> findAllCompanies() {
        List<Employee> employees = getEmployees();

        Set<String> companies = employees.stream()
                .flatMap(employee -> employee.getJobHistory().stream()
                        .map(JobHistoryEntry::getCompany))
                .collect(Collectors.toSet());
        return companies;
    }

    Integer findMinimalAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Integer minimalAge = employees.stream()
                .map(employee -> employee.getPerson().getAge())
                .min(Integer::compare).get();

        return minimalAge;
    }

    Double calcAverageAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Double expected = employees.stream()
                .mapToDouble(employee -> employee.getPerson().getAge())
                .average()
                .getAsDouble();
        return expected;
    }

    Person findPersonWithLongestFullName() {
        List<Employee> employees = getEmployees();

        Person expected = employees.stream()
                .map(Employee::getPerson)
                .reduce((person, person2) ->
                        person.getFirstName().length() + person.getLastName().length() >
                        person2.getFirstName().length() + person2.getLastName().length()
                        ? person : person2).get();
        return expected;
    }

    Employee findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = getEmployees();

        Employee expected = employees.stream()
                .reduce((employee, employee2) ->
                        employee.getJobHistory().stream()
                                .map(JobHistoryEntry::getDuration)
                                .max(Integer::compareTo).get() >
                        employee2.getJobHistory().stream()
                                .map(JobHistoryEntry::getDuration)
                                .max(Integer::compareTo).get()
                        ? employee : employee2).get();
        return expected;
    }

}
