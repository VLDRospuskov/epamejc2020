package homeworks.HW8_functionalAndStream.streamOperations;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static homeworks.HW8_functionalAndStream.streamOperations.GenerateData.getEmployees;

public class StreamOperations {

    void findPersonsEverWorkedInEpam() {
        List<Employee> employees = getEmployees();

        // TODO реализация, использовать Collectors.toList()
        List<Person> personsEverWorkedInEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().stream()
                        .anyMatch(job -> job.getCompany().equals("EPAM")))
                .map(Employee::getPerson).collect(Collectors.toList());

        System.out.println("These people ever worked in EPAM: " + personsEverWorkedInEpam + "\n");
    }

    void findPersonsBeganCareerInEpam() {
        List<Employee> employees = getEmployees();

        List<Person> startedFromEpam = employees.stream()
                .filter(employee -> employee.getJobHistory()
                        .stream().findFirst().get().getCompany().equals("EPAM"))
                .map(Employee::getPerson).collect(Collectors.toList());

        System.out.println("These people started a career in EPAM: " + startedFromEpam + "\n");
    }

    void findAllCompanies() {
        List<Employee> employees = getEmployees();

        Set<String> companies = employees.stream()
                .flatMap(employee -> employee.getJobHistory().stream().map(JobHistoryEntry::getCompany))
                .collect(Collectors.toSet());

        System.out.println("This is all companies list: " + companies + "\n");
    }

    void findMinimalAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Integer minimalAge = employees.stream()
                .min((employee1, employee2) -> {
                    Integer age1 = employee1.getPerson().getAge();
                    Integer age2 = employee2.getPerson().getAge();
                    return age1.compareTo(age2);
                })
                .map(e -> e.getPerson().getAge())
                .get();

        System.out.println("Minimal age is: " + minimalAge + "\n");
    }

    void calcAverageAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Double expected = employees.stream()
                .collect(Collectors.averagingDouble(e -> e.getPerson().getAge()));

        System.out.println("Average age of employees: " + expected + "\n");

    }

    void findPersonWithLongestFullName() {
        List<Employee> employees = getEmployees();

        Person expected = employees.stream()
                .max((employee1, employee2) -> {
                    Integer fullName1 = employee1.getPerson().getFirstName().length()
                            + employee1.getPerson().getLastName().length();
                    Integer fullName2 = employee2.getPerson().getFirstName().length()
                            + employee2.getPerson().getLastName().length();
                    return fullName1.compareTo(fullName2);
                })
                .get().getPerson();

        System.out.println("The employee with longest name is: " + expected + "\n");
    }

    void findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = getEmployees();

        Employee expected = employees.stream()
                .reduce((employee1, employee2) ->
                        employee1.getJobHistory().stream().map(JobHistoryEntry::getDuration)
                                .max(Integer::compareTo).orElse(0) > employee2.getJobHistory().stream()
                                        .map(JobHistoryEntry::getDuration)
                                        .max(Integer::compareTo).orElse(0)
                                ? employee1 : employee2)
                .orElse(null);

        System.out.println("The employee with the biggest experience in one position" + expected);
    }
}

