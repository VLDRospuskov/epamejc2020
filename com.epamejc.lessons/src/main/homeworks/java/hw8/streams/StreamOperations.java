package homeworks.java.hw8.streams;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static homeworks.java.hw8.streams.GenerateData.getEmployees;

@SuppressWarnings({"unused"})
public class StreamOperations {

    void findPersonsEverWorkedInEpam() {
        List<Employee> employees = getEmployees();

        List<Person> personsEverWorkedInEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().stream()
                        .anyMatch(jobHistory -> jobHistory.getCompany().equals("EPAM")))
                .map(Employee::getPerson)
                .collect(Collectors.toList());
        System.out.println(personsEverWorkedInEpam);
    }

    void findPersonsBeganCareerInEpam() {
        List<Employee> employees = getEmployees();

        List<Person> startedFromEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().stream()
                        .findFirst()
                        .get()
                        .getCompany().equals("EPAM"))
                .map(Employee::getPerson)
                .collect(Collectors.toList());
        System.out.println(startedFromEpam);
    }

    void findAllCompanies() {
        List<Employee> employees = getEmployees();

        Set<String> companies = employees.stream()
                .map(Employee::getJobHistory)
                .flatMap(Collection::stream)
                .map(JobHistoryEntry::getCompany)
                .collect(Collectors.toSet());
        System.out.println(companies);
    }

    void findMinimalAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Integer minimalAge = employees.stream()
                .map(employee -> employee.getPerson().getAge())
                .min(Comparator.comparing(person -> person))
                .get();

        System.out.println(minimalAge);
    }

    void calcAverageAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Double expected = employees.stream()
                .collect(Collectors.averagingDouble(employee -> employee.getPerson().getAge()));

        System.out.println(expected);

    }

    void findPersonWithLongestFullName() {
        List<Employee> employees = getEmployees();

        Person expected = employees.stream()
                .map(Employee::getPerson)
                .max((person1, person2) -> {
                    Integer i1 = person1.getFirstName().length() + person1.getLastName().length();
                    Integer i2 = person2.getFirstName().length() + person2.getLastName().length();
                    return i1.compareTo(i2);
                })
                .get();

        System.out.println(expected);
    }

    void findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = getEmployees();

        Employee expected = employees.stream()
                .max(Comparator.comparing(employee -> employee.getJobHistory().stream()
                        .map(JobHistoryEntry::getDuration)
                        .max(Integer::compareTo).get()))
                .get();

        System.out.println(expected);
    }

}




