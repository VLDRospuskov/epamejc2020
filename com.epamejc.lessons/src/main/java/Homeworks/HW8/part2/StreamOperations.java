package Homeworks.HW8.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static Homeworks.HW8.part2.GenerateData.getEmployees;

public class StreamOperations {

    void findPersonsEverWorkedInEpam() {
        List<Employee> employees = getEmployees();

        List<Person> personsEverWorkedInEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().stream().anyMatch(jobHistoryEntry -> jobHistoryEntry.getCompany().equalsIgnoreCase("Epam")))
                .map(Employee::getPerson)
                .collect(Collectors.toList());

        System.out.println("Persons Ever Worked In Epam:");
        System.out.println(personsEverWorkedInEpam);
        System.out.println("");
    }

    void findPersonsBeganCareerInEpam() {
        List<Employee> employees = getEmployees();

        List<Person> startedFromEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().get(0).getCompany().equalsIgnoreCase("Epam"))
                .map(Employee::getPerson)
                .collect(Collectors.toList());

        System.out.println("Persons Began Career In Epam:");
        System.out.println(startedFromEpam);
        System.out.println("");
    }

    void findAllCompanies() {
        List<Employee> employees = getEmployees();

        Set<String> companies = employees.stream()
                .map(employee -> employee.getJobHistory().stream().map(JobHistoryEntry::getCompany))
                .reduce(Stream::concat)
                .orElse(new ArrayList<String>().stream())
                .collect(Collectors.toSet());

        System.out.println("All Companies:");
        System.out.println(companies);
        System.out.println("");
    }

    void findMinimalAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Integer minimalAge = employees.stream()
                .map(employee -> employee.getPerson().getAge())
                .min(Integer::compareTo)
                .orElse(null);

        System.out.println("Minimal Age Of Employees:");
        System.out.println(minimalAge);
        System.out.println("");
    }

    void calcAverageAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Double average = employees.stream()
                .mapToDouble(employee -> employee.getPerson().getAge())
                .average()
                .orElse(0);

        System.out.println("Average Age Of Employees:");
        System.out.println(average);
        System.out.println("");
    }

    void findPersonWithLongestFullName() {
        List<Employee> employees = getEmployees();

        Person longest = employees.stream()
                .map(Employee::getPerson)
                .reduce((p1, p2) ->
                        p1.getFirstName().length() + p1.getLastName().length() >
                        p2.getFirstName().length() + p2.getLastName().length()
                        ? p1 : p2)
                .orElse(null);

        System.out.println("Person With Longest Full Name:");
        System.out.println(longest);
        System.out.println("");
    }

    void findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = getEmployees();

        Employee maxDuration = employees.stream()
                .reduce((e1, e2) ->
                        e1.getJobHistory().stream()
                            .map(JobHistoryEntry::getDuration)
                            .max(Integer::compareTo).orElse(0) >
                        e2.getJobHistory().stream()
                            .map(JobHistoryEntry::getDuration)
                            .max(Integer::compareTo).orElse(0)
                        ? e1 : e2)
                .orElse(null);

        System.out.println("Employee With Maximum Duration At One Position:");
        System.out.println(maxDuration);
        System.out.println("");
    }

}