package homework8.task2;


import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static homework8.task2.GenerateData.getEmployees;

@SuppressWarnings({"unused"})
public class StreamOperations {

    void findPersonsEverWorkedInEpam() {
        List<Employee> employees = getEmployees();
        List<Person> personsEverWorkedInEpam;

//        personsEverWorkedInEpam - should contain employees.get(0),  employees.get(1),
//                employees.get(4), employees.get(5)

        personsEverWorkedInEpam = employees.stream().
                filter(employee -> employee.getJobHistory().stream()
                        .anyMatch(company -> company.getCompany().equals("EPAM")))
                .map(Employee::getPerson)
                .collect(Collectors.toList());

        System.out.println("This persons worked in the EPAM:");
        for (Person person : personsEverWorkedInEpam) {
            System.out.println(person);
        }
        System.out.println();
    }

    void findPersonsBeganCareerInEpam() {
        List<Employee> employees = getEmployees();
        List<Person> startedFromEpam;

//        startedFromEpam - should contain
//                employees.get(0).getPerson(),
//                employees.get(1).getPerson(),
//                employees.get(4).getPerson()

        startedFromEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().get(0).getCompany().equals("EPAM"))
                .map(Employee::getPerson)
                .collect(Collectors.toList());

        System.out.println("This persons have began their careers from the EPAM:");
        for (Person person : startedFromEpam) {
            System.out.println(person);
        }
        System.out.println();
    }

    void findAllCompanies() {
        List<Employee> employees = getEmployees();
        Set<String> findAllCompanies;

//        companies - should contain "EPAM", "google", "yandex", "mail.ru", "T-Systems"

        findAllCompanies = employees.stream()
                .flatMap(employee -> employee.getJobHistory().stream().
                        map(JobHistoryEntry::getCompany))
                .collect(Collectors.toSet());

        System.out.println("All companies in which employees have worked: ");
        for (String company : findAllCompanies) {
            System.out.println(company);
        }
        System.out.println();
    }

    void findMinimalAgeOfEmployees() {
        List<Employee> employees = getEmployees();
        Integer minimalAge;

//        minmalAge = 21

        Optional<Integer> minimalAgeOpt = employees.stream()
                .map(Employee::getPerson)
                .map(Person::getAge)
                .reduce((firstAge, secondAge) -> firstAge < secondAge ? firstAge : secondAge);

        System.out.println("Minimum age among all employees: ");
        minimalAgeOpt.ifPresent(System.out::println);
        System.out.println();
    }

    // Посчитать средний возраст работников
    void calcAverageAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Double expected;
        Optional<Integer> expectedOptInt = employees.stream()
                .map(Employee::getPerson)
                .map(Person::getAge)
                .reduce(Integer::sum);

        Optional<Double> expectedOptDoub = expectedOptInt.map(Integer::doubleValue);

        System.out.println("Average age of all employees: ");
        expectedOptDoub.ifPresent(x -> System.out.println(x / employees.size()));
        System.out.println();
    }

    // Найти Person с самым длинным fullName
    void findPersonWithLongestFullName() {
        List<Employee> employees = getEmployees();
        Person expected;

        Optional<Person> expectedOpt = employees.stream()
                .map(Employee::getPerson)
                .reduce((person1, person2) ->
                        ((person1.getFirstName() + person1.getLastName()).length())
                                > ((person2.getFirstName() + person2.getLastName()).length())
                                ? person1 : person2);

        System.out.println("Employee with longest full name: ");
        expectedOpt.ifPresent(System.out::println);
        System.out.println();
    }

    // Найти работника с самой большой продолжительность на одной же позиции
    void findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = getEmployees();
        Employee expected;

        expected = employees.stream()
                .reduce((employee1, employee2) ->
                        employee1.getJobHistory().stream()
                                .map(JobHistoryEntry::getDuration)
                                .max(Integer::compareTo).orElse(0)
                                > employee2.getJobHistory().stream()
                                .map(JobHistoryEntry::getDuration)
                                .max(Integer::compareTo).orElse(0)
                                ? employee1 : employee2)
                .orElse(null);

        System.out.println("Employee with maximum duration at one position: " + "\n" + expected);
    }
}
