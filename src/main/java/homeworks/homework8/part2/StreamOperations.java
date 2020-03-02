package homeworks.homework8.part2;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static homeworks.homework8.part2.GenerateData.getEmployees;


public class StreamOperations {

    void showAllStatistics () {
        findPersonsEverWorkedInEpam();
        findPersonsBeganCareerInEpam();
        findAllCompanies();
        findMinimalAgeOfEmployees();
        calcAverageAgeOfEmployees();
        findPersonWithLongestFullName();
        findEmployeeWithMaximumDurationAtOnePosition();
    }

    void findPersonsEverWorkedInEpam() {
        List<Employee> employees = getEmployees();

        List<Person> personsEverWorkedInEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().stream()
                        .anyMatch(jobHistoryEntry -> jobHistoryEntry
                                .getCompany()
                                .equalsIgnoreCase("epam")))
                .map(Employee::getPerson)
                .collect(Collectors.toList());

        System.out.println("_______________________________\n" +
                "Persons who ever worked in EPAM:");
        personsEverWorkedInEpam.forEach(System.out::println);
        System.out.println("_______________________________\n");
    }

    void findPersonsBeganCareerInEpam() {
        List<Employee> employees = getEmployees();

        List<Person> startedFromEpam = employees.stream()
                .filter(employee -> employee.getJobHistory()
                        .get(0)
                        .getCompany()
                        .equalsIgnoreCase("epam"))
                .map(Employee::getPerson)
                .collect(Collectors.toList());

        System.out.println("_______________________________\n" +
                "Persons who began career from EPAM:");
        startedFromEpam.forEach(System.out::println);
        System.out.println("_______________________________\n");
    }

    void findAllCompanies() {
        List<Employee> employees = getEmployees();

        Set<String> companies = employees.stream()
                .flatMap(employee -> employee.getJobHistory().stream().map(JobHistoryEntry::getCompany))
                .collect(Collectors.toSet());


        System.out.println("_______________________________\n" +
                "All shown companies:");
        companies.forEach(company -> System.out.printf("%s ", company));
        System.out.println("\n_______________________________\n");
    }

    void findMinimalAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Integer minimalAge = employees.stream()
                .map(employee -> employee.getPerson().getAge())
                .min(Integer::compare)
                .orElseGet(() -> {
                    System.out.println("No employee found");
                    return null;
                });

        System.out.printf("_______________________________\n" +
                "Minimal age of employees: %d\n", minimalAge);
        System.out.println("_______________________________\n");
    }

    void calcAverageAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Double expected = employees.stream()
                .map(Employee::getPerson)
                .collect(Collectors.averagingInt(Person::getAge));

        System.out.printf("_______________________________\n" +
                "Average age of employees: %f\n", expected);
        System.out.println("_______________________________\n");


    }

    void findPersonWithLongestFullName() {
        List<Employee> employees = getEmployees();

        Person expected = employees.stream()
                .map(Employee::getPerson)
                .max((Comparator.comparingInt(person -> person.getFirstName().length() + person.getLastName().length())))
                .orElseGet(() -> {
                    System.out.println("No employee found");
                    return null;
                });

        System.out.println("_______________________________\n" +
                "Person with longest full name: " + expected);
        System.out.println("_______________________________\n");

    }

    void findEmployeeWithMaximumDurationAtOnePosition() {

        List<Employee> employees = getEmployees();

        Employee expected = employees.stream()
                .reduce((employee1, employee2) -> {
                    int years1 = employee1.getJobHistory().stream()
                            .map(JobHistoryEntry::getDuration)
                            .max(Integer::compare)
                            .orElseGet(() -> {
                                System.out.println("Employee history is empty");
                                return 0;
                            });
                    int years2 = employee2.getJobHistory().stream()
                            .map(JobHistoryEntry::getDuration)
                            .max(Integer::compare)
                            .orElseGet(() -> {
                                System.out.println("Employee history is empty");
                                return 0;
                            });
                    return years1 > years2 ? employee1 : employee2;
                })
                .orElseGet(() -> {
                    System.out.println("No employee found");
                    return null;
                });

        assert expected != null;
        System.out.println("_______________________________\n" +
                "Employee with max duration on one position: " +
                expected.getPerson().getFirstName() + " " +
                expected.getPerson().getLastName() + " " +
                expected.getJobHistory().stream()
                    .map(JobHistoryEntry::getDuration)
                    .collect(Collectors.toList()));
        System.out.println("_______________________________\n");
    }
}
