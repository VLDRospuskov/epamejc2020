package homeworks.homework8.stream_operations;

import java.util.*;
import java.util.stream.Collectors;

import static homeworks.homework8.stream_operations.GenerateData.*;


@SuppressWarnings({"unused"})
public class StreamOperations {

    void findPersonsEverWorkedInEpam() {
        List<Employee> employees = getEmployees();

        // TODO реализация, использовать Collectors.toList()
        List<Person> personsEverWorkedInEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().stream()
                        .anyMatch(job -> job.getCompany().equals("EPAM")))
                .map(Employee::getPerson)
                .collect(Collectors.toList());

        System.out.println(personsEverWorkedInEpam.toString());
//        personsEverWorkedInEpam - should contain employees.get(0),  employees.get(1),
//                employees.get(4), employees.get(5)
    }

    void findPersonsBeganCareerInEpam() {
        List<Employee> employees = getEmployees();

        // TODO реализация, использовать Collectors.toList()
        List<Person> startedFromEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().get(0).getCompany().equals("EPAM"))
                .map(Employee::getPerson)
                .collect(Collectors.toList());

        System.out.println(startedFromEpam.toString());
//        startedFromEpam - should contain
//                employees.get(0).getPerson(),
//                employees.get(1).getPerson(),
//                employees.get(4).getPerson()
    }

    void findAllCompanies() {
        List<Employee> employees = getEmployees();

        // TODO реализация, использовать Collectors.toSet()
        Set<String> companies = employees.stream()
                .flatMap(firms -> firms.getJobHistory().stream().map(JobHistoryEntry::getCompany))
                .collect(Collectors.toSet());

        System.out.println(companies.toString());

//        companies - should contain "EPAM", "google", "yandex", "mail.ru", "T-Systems"
    }

    void findMinimalAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        // TODO реализация
        Integer minimalAge = employees.stream()
                .min(Comparator.comparingInt(employee -> employee.getPerson().getAge()))
                .map(employee -> employee.getPerson().getAge())
                .get();

        System.out.println("Minimal age is " + minimalAge);
        // minmalAge = 21
    }

    // Посчитать средний возраст работников
    void calcAverageAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Double expected = employees.stream()
                .mapToDouble(employee -> employee.getPerson().getAge())
                .average()
                .getAsDouble();

        System.out.println("Average age is " + expected);
    }

    // Найти Person с самым длинным fullName
    void findPersonWithLongestFullName() {
        List<Employee> employees = getEmployees();

        Person expected = employees.stream()
                .max(Comparator.comparingInt(employee -> employee.getPerson().getFirstName().length()
                                                       + employee.getPerson().getLastName().length()))
                .map(Employee::getPerson)
                .get();

        System.out.println("Longest full name " + expected.toString());
    }

    // Найти работника с самой большой продолжительность на одной же позиции
    void findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = getEmployees();

        Employee expected = employees.stream()
                .max(Comparator.comparingInt(employee -> employee.getJobHistory().stream()
                        .map(JobHistoryEntry::getDuration).max(Integer::compareTo).get()))
                .get();

        System.out.println("Max duration employee " + expected.toString());
    }

}
