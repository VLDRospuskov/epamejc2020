package main.homeworks.hw8.streamOperations;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings({"unused"})
public class StreamOperations {

    void findPersonsEverWorkedInEpam() {
        List<Employee> employees = GenerateData.getEmployees();

        List<Person> personsEverWorkedInEpam = employees.stream()
                                                .filter(employee -> employee.getJobHistory().stream()
                                                                    .filter(job -> job.getCompany().equals("EPAM"))
                                                                    .count() > 0)
                                                .map(employee -> employee.getPerson())
                                                .collect(Collectors.toList());

//        personsEverWorkedInEpam - should contain employees.get(0),  employees.get(1),
//                employees.get(4), employees.get(5)
        System.out.println("People ever worked in EPAM: " + personsEverWorkedInEpam);
    }

    void findPersonsBeganCareerInEpam() {
        List<Employee> employees = GenerateData.getEmployees();

        List<Person> startedFromEpam = employees.stream()
                                        .filter(employee -> employee.getJobHistory().stream()
                                                            .limit(1).filter(job -> job.getCompany().equals("EPAM"))
                                                            .count() > 0)
                                        .map(employee -> employee.getPerson())
                                        .collect(Collectors.toList());

//        startedFromEpam - should contain
//                employees.get(0).getPerson(),
//                employees.get(1).getPerson(),
//                employees.get(4).getPerson()

        System.out.println("People who began their carrer in EPAM: " + startedFromEpam);

    }

    void findAllCompanies() {
        List<Employee> employees = GenerateData.getEmployees();

        Set<String> companies = employees.stream()
                                .flatMap(employee -> employee.getJobHistory().stream().map(job -> job.getCompany()))
                                .collect(Collectors.toSet());

//        companies - should contain "EPAM", "google", "yandex", "mail.ru", "T-Systems"
        System.out.println("All companies: " + companies);
    }

    void findMinimalAgeOfEmployees() {
        List<Employee> employees = GenerateData.getEmployees();

        Integer minimalAge = employees.stream()
                             .map(employee -> employee.getPerson().getAge())
                             .min(Integer::compareTo)
                             .get();

        // minmalAge = 21
        System.out.println("Minimal age: " + minimalAge);
    }

    // Посчитать средний возраст работников
    void calcAverageAgeOfEmployees() {
        List<Employee> employees = GenerateData.getEmployees();

        Double expected = employees.stream()
                          .map(employee -> employee.getPerson())
                          .collect(Collectors.averagingInt(Person::getAge));

        System.out.println("Average age:" + expected);

    }

    // Найти Person с самым длинным fullName
    void findPersonWithLongestFullName() {
        List<Employee> employees = GenerateData.getEmployees();

        Person expected = employees.stream()
                          .map(Employee::getPerson)
                          .max(Comparator.comparingInt(person -> person.getFirstName().length() + person.getLastName().length()))
                          .get();

        System.out.println("Person with longest name: " + expected);
    }

    // Найти работника с самой большой продолжительность на одной же позиции
    void findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = GenerateData.getEmployees();

        Employee expected = employees.stream()
                            .reduce((e1, e2) -> e1.getJobHistory().stream()
                                                .map(JobHistoryEntry::getDuration)
                                                .max(Integer::compareTo)
                                                .orElse(0)
                                                > e2.getJobHistory().stream()
                                                    .map(JobHistoryEntry::getDuration).max(Integer::compareTo).orElse(0)
                            ? e1 : e2)
                            .orElse(null);

        System.out.println("Person with maximum duration at one position: " + expected);

    }

}
