package com.epamejc.lessons.src.homework.homework8.java8.streams;

import lombok.SneakyThrows;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings({"unused"})
public class StreamOperations {

    List<Person> findPersonsEverWorkedInEpam() {
        List<Employee> employees = GenerateData.getEmployees();
        return employees.stream()
                .filter(employee -> employee.getJobHistory().stream()
                        .anyMatch(jobHistoryEntry -> jobHistoryEntry.getCompany().equals("EPAM"))
                ).map(Employee::getPerson)
                .collect(Collectors.toList());
    }

    List<Person> findPersonsBeganCareerInEpam() {
        List<Employee> employees = GenerateData.getEmployees();
        return employees.stream()
                .filter(employee -> {
                            if (employee.getJobHistory().size() > 0) {
                                return employee.getJobHistory().get(0).getCompany().equals("EPAM");
                            }
                            return false;
                        }
                ).map(Employee::getPerson)
                .collect(Collectors.toList());
    }

    Set<String> findAllCompanies() {
        List<Employee> employees = GenerateData.getEmployees();
        return employees.stream().flatMap(employee -> employee.getJobHistory().stream())
                .map(JobHistoryEntry::getCompany)
                .collect(Collectors.toSet());
    }

    Integer findMinimalAgeOfEmployees() {
        List<Employee> employees = GenerateData.getEmployees();
        return employees.stream()
                .map(employee -> employee.getPerson().getAge()).min(Integer::compareTo).orElse(-1);
    }

    Double calcAverageAgeOfEmployees() {
        List<Employee> employees = GenerateData.getEmployees();
        return employees.stream()
                .mapToDouble(employee -> employee.getPerson().getAge()).average().orElse(-1);
    }

    @SneakyThrows
    Person findPersonWithLongestFullName() {
        List<Employee> employees = GenerateData.getEmployees();
        return employees.stream().map(Employee::getPerson).max((o1, o2) -> {
            String fullName1 = o1.getFirstName() + " " + o1.getLastName();
            String fullName2 = o2.getFirstName() + " " + o2.getLastName();
            return fullName1.length() - fullName2.length();
        }).orElseThrow(() -> new Exception("There are no people on the list of employees"));
    }

    Person findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = GenerateData.getEmployees();
        return employees.stream().max(Comparator.comparingInt(this::getMaxDuration)).get().getPerson();
    }

    private int getMaxDuration(Employee employee) {
        return employee.getJobHistory().stream()
                .map(JobHistoryEntry::getDuration)
                .max(Integer::compareTo).orElse(-1);
    }

}
