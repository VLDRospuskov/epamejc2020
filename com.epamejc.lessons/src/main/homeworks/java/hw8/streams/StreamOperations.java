package homeworks.java.hw8.streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static homeworks.java.hw8.streams.GenerateData.getEmployees;

@SuppressWarnings({"unused"})
public class StreamOperations {

    void findPersonsEverWorkedInEpam() {
        List<Employee> employees = getEmployees();

        // TODO реализация, использовать Collectors.toList()
        List<Person> personsEverWorkedInEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().stream()
                        .anyMatch(jobHistory -> jobHistory.getCompany().equals("EPAM")))
                .map(employee -> employee.getPerson())
                .collect(Collectors.toList());
        System.out.println(personsEverWorkedInEpam);

//        personsEverWorkedInEpam - should contain employees.get(0),  employees.get(1),
//                employees.get(4), employees.get(5)
    }

    void findPersonsBeganCareerInEpam() {
        List<Employee> employees = getEmployees();

        // TODO реализация, использовать Collectors.toList()
        List<Person> startedFromEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().stream()
                        .findFirst()
                        .get()
                        .getCompany().equals("EPAM"))
                .map(employee -> employee.getPerson())
                .collect(Collectors.toList());
        System.out.println(startedFromEpam);
//        startedFromEpam - should contain
//                employees.get(0).getPerson(),
//                employees.get(1).getPerson(),
//                employees.get(4).getPerson()
    }

    void findAllCompanies() {
        List<Employee> employees = getEmployees();

        // TODO реализация, использовать Collectors.toSet()
        Set<String> companies = employees.stream()
                .map(employee -> employee.getJobHistory())
                .flatMap(jobHistoryEntries -> jobHistoryEntries.stream())
                .map(company -> company.getCompany())
                .collect(Collectors.toSet());
        System.out.println(companies);

//        companies - should contain "EPAM", "google", "yandex", "mail.ru", "T-Systems"
    }

    void findMinimalAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        // TODO реализация

        Integer minimalAge = employees.stream()
                .min((employee1, employee2) -> {
                    Integer i1 = employee1.getPerson().getAge();
                    Integer i2 = employee2.getPerson().getAge();
                        return i1.compareTo(i2); } )
                .map(employee -> employee.getPerson().getAge())
                .get();
        System.out.println(minimalAge);
        // minmalAge = 21
    }

    // Посчитать средний возраст работников
    void calcAverageAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Double expected = employees.stream()
                .collect(Collectors.averagingDouble(employee -> employee.getPerson().getAge()));
        System.out.println(expected);

    }

    // Найти Person с самым длинным fullName
    void findPersonWithLongestFullName() {
        List<Employee> employees = getEmployees();

        Person expected = employees.stream()
                .map(employee -> employee.getPerson())
                .max((person1, person2) -> {
                    Integer i1 = person1.getFirstName().length() + person1.getLastName().length();
                    Integer i2 = person2.getFirstName().length() + person2.getLastName().length();
                    return i1.compareTo(i2); } )
                .get();
        System.out.println(expected);
    }

    // Найти работника с самой большой продолжительность на одной же позиции
    void findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = getEmployees();

        Employee expected = employees.stream()
                .reduce((employee1, employee2) -> employee1.getJobHistory().stream()
                        .map(JobHistoryEntry::getDuration)
                        .max(Integer::compareTo).orElse(0) > employee2.getJobHistory().stream()
                                .map(JobHistoryEntry::getDuration)
                                .max(Integer::compareTo).orElse(0)
                                ? employee1 : employee2)
                .orElse(null);

        System.out.println(expected);


    }

}
