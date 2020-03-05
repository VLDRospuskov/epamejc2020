package homeworks.java.hw8.streamOperations;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static homeworks.java.hw8.streamOperations.GenerateData.getEmployees;

public class StreamOperations {

    void findPersonsEverWorkedInEpam() {
        List<Employee> employees = getEmployees();

        List<Person> personsEverWorkedInEpam = employees.stream()
                .filter(e -> e.getJobHistory().stream()
                        .filter(j -> j.getCompany().equals("EPAM"))
                        .count() != 0)
                .map(e -> e.getPerson())
                .collect(Collectors.toList());

        System.out.println("The list of persons who ever worked in EPAM:\n" + personsEverWorkedInEpam + "\n");
    }

    void findPersonsBeganCareerInEpam() {
        List<Employee> employees = getEmployees();

        List<Person> startedFromEpam = employees.stream()
                .filter(e -> e.getJobHistory().stream()
                        .limit(1)
                        .filter(j -> j.getCompany().equals("EPAM"))
                        .count() != 0)
                .map(e -> e.getPerson())
                .collect(Collectors.toList());

        System.out.println("The list of employees who started there creer in EPAM:\n" + startedFromEpam + "\n");
    }

    void findAllCompanies() {
        List<Employee> employees = getEmployees();

        Set<String> companies = employees.stream()
                .flatMap(e -> e.getJobHistory().stream().map(j -> j.getCompany()))
                .collect(Collectors.toSet());

        System.out.println("The list of all presented companies:\n" + companies + "\n");
    }

    void findMinimalAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Integer minimalAge = employees.stream()
                .map(e -> e.getPerson().getAge())
                .min(Integer::compareTo)
                .get();

        System.out.println("A minimal age of employees is " + minimalAge + "\n");
    }

    void calcAverageAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Double expected = employees.stream()
                .mapToDouble(e -> e.getPerson().getAge())
                .average()
                .getAsDouble();

        System.out.println("An average age of employees is " + expected + "\n");
    }

    void findPersonWithLongestFullName() {
        List<Employee> employees = getEmployees();

        Person expected = employees.stream()
                .map(e -> e.getPerson())
                .reduce(
                        (x, y) -> {
                            if ((x.getFirstName() + x.getLastName()).length() >=
                                    (y.getFirstName() + y.getLastName()).length()) {
                                return x;
                            } else {
                                return y;
                            }
                        })
                .get();

        System.out.println("Person with longest full name is " + expected);
        int length = expected.getFirstName().length() + expected.getLastName().length();
        System.out.println("Full name length is " + length + "\n");
    }

    void findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = getEmployees();

        Employee expected = employees.stream()
                .reduce((x, y) -> {
                    if (x.getJobHistory().stream().map(j -> j.getDuration()).max(Integer::compareTo).get() >=
                            y.getJobHistory().stream().map(j -> j.getDuration()).max(Integer::compareTo).get()) {
                        return x;
                    } else {
                        return y;
                    }
                })
                .get();

        System.out.println("Employee with maximum duration at one position is \n" + expected + "\n");
    }

}
