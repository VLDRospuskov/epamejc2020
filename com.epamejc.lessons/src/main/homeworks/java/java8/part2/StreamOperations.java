package homeworks.java.java8.part2;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static homeworks.java.java8.part2.GenerateData.getEmployees;

@SuppressWarnings({"unused"})
public class StreamOperations {

    List<Person> findPersonsEverWorkedInEpam() {
        List<Employee> employees = getEmployees();

        // TODO реализация, использовать Collectors.toList()
        List<Person> personsEverWorkedInEpam = employees.stream()
                .filter(employee -> employee.getJobHistory()
                        .stream()
                        .anyMatch(jobHistory -> jobHistory.getCompany().equalsIgnoreCase("EPAM")))
                .map(Employee::getPerson)
                .collect(Collectors.toList());

        return personsEverWorkedInEpam;
//        personsEverWorkedInEpam - should contain employees.get(0),  employees.get(1),
//                employees.get(4), employees.get(5)
    }

    List<Person> findPersonsBeganCareerInEpam() {
        List<Employee> employees = getEmployees();

        // TODO реализация, использовать Collectors.toList()
        List<Person> startedFromEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().get(0).getCompany().equalsIgnoreCase("EPAM"))
                .map(Employee::getPerson)
                .collect(Collectors.toList());

        return startedFromEpam;
//        startedFromEpam - should contain
//                employees.get(0).getPerson(),
//                employees.get(1).getPerson(),
//                employees.get(4).getPerson()
    }

    Set<String> findAllCompanies() {
        List<Employee> employees = getEmployees();

        // TODO реализация, использовать Collectors.toSet()
        Set<String> companies = employees.stream()
                .map(Employee::getJobHistory)
                .flatMap(Collection::stream)
                .map(JobHistoryEntry::getCompany)
                .collect(Collectors.toSet());

        return companies;
//        companies - should contain "EPAM", "google", "yandex", "mail.ru", "T-Systems"
    }

    Integer findMinimalAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        // TODO реализация
        Integer minimalAge = employees.stream()
                .map(Employee::getPerson)
                .map(Person::getAge)
                .min(Integer::compareTo)
                .orElse(0);

        return minimalAge;
        // minmalAge = 21
    }

    // Посчитать средний возраст работников
    Double calcAverageAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Double expected = employees.stream()
                .map(Employee::getPerson)
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.);

        return expected;

    }

    // Найти Person с самым длинным fullName
    Person findPersonWithLongestFullName() {
        List<Employee> employees = getEmployees();

        Person expected = employees.stream()
                .map(Employee::getPerson)
                .reduce((person1, person2) -> person1.getFirstName().length() + person1.getLastName().length() >
                        person2.getFirstName().length() + person2.getLastName().length() ? person1 : person2)
                .orElseThrow(() -> new RuntimeException("There are no employees in the list"));

        return expected;

    }

    // Найти работника с самой большой продолжительность на одной же позиции
    Employee findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = getEmployees();

        Employee expected = employees.stream()
                .max(Comparator.comparingInt(this::getMaxDuration))
                .orElseThrow(() -> new RuntimeException("There are no employees in the list"));

        return expected;

    }

    private Integer getMaxDuration (Employee employee) {

        return employee.getJobHistory().stream()
                .map(JobHistoryEntry::getDuration)
                .max(Integer::compareTo)
                .orElse(0);

    }
}