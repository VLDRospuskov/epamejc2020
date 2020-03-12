package Homeworks.HW8.part2;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static Homeworks.HW8.part2.GenerateData.getEmployees;

public class StreamOperations {

    void findPersonsEverWorkedInEpam() {
        List<Employee> employees = getEmployees();

        List<Person> personsEverWorkedInEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().stream()
                        .anyMatch(jobHistoryEntry -> jobHistoryEntry.getCompany().equals("EPAM")))
                .map(Employee::getPerson)
                .collect(Collectors.toList());

        System.out.println("Persons Ever Worked In Epam: \n" + personsEverWorkedInEpam + "\n");
    }

    void findPersonsBeganCareerInEpam() {
        List<Employee> employees = getEmployees();

        List<Person> startedFromEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().stream().findFirst().get().getCompany().equals("EPAM"))
                .map(Employee::getPerson)
                .collect(Collectors.toList());

        System.out.println("Persons Began Career In Epam: \n" + startedFromEpam + "\n");
    }

    void findAllCompanies() {
        List<Employee> employees = getEmployees();

        Set<String> companies = employees.stream()
                .flatMap(employee -> employee.getJobHistory().stream().map(JobHistoryEntry::getCompany))
                .collect(Collectors.toSet());

        System.out.println("All Companies: \n" + companies + "\n");
    }

    void findMinimalAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Integer minimalAge = employees.stream()
                .min((employee1, employee2) -> {
                    Integer age1 = employee1.getPerson().getAge();
                    Integer age2 = employee2.getPerson().getAge();
                    return age1.compareTo(age2);
                })
                .map(employee -> employee.getPerson().getAge())
                .get();

        System.out.println("Minimal Age Of Employees: \n" + minimalAge + "\n");
    }

    void calcAverageAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Double average = employees.stream()
                .collect(Collectors.averagingDouble(employee -> employee.getPerson().getAge()));

        System.out.println("Average Age Of Employees: \n" + average + "\n");
    }

    void findPersonWithLongestFullName() {
        List<Employee> employees = getEmployees();

        Person longest = employees.stream()
                .max((employee1, employee2) -> {
                    String name1 = employee1.getPerson().getFirstName() + " " + employee1.getPerson().getLastName();
                    Integer length1 = name1.length();
                    String name2 = employee2.getPerson().getFirstName() + " " + employee1.getPerson().getLastName();
                    Integer length2 = name2.length();
                    return length1.compareTo(length2);
                })
                .get().getPerson();

        System.out.println("Person With Longest Full Name: \n" + longest + "\n");
    }

    void findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = getEmployees();

        Employee duration = employees.stream()
                .reduce((employee1, employee2) ->
                        employee1.getJobHistory().stream()
                                .map(JobHistoryEntry::getDuration)
                                .max(Integer::compareTo)
                                .orElse(0)
                                > employee2.getJobHistory()
                                .stream().map(JobHistoryEntry::getDuration)
                                .max(Integer::compareTo).orElse(0)
                                ? employee1 : employee2)
                .orElse(null);

        System.out.println("Employee With Maximum Duration At One Position: \n" + duration + "\n");
    }
}