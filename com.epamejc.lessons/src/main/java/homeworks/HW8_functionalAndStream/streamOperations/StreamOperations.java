package homeworks.HW8_functionalAndStream.streamOperations;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static homeworks.HW8_functionalAndStream.streamOperations.GenerateData.getEmployees;

@SuppressWarnings({"unused"})
public class StreamOperations {

    void findPersonsEverWorkedInEpam() {
        List<Employee> employees = getEmployees();

        // TODO реализация, использовать Collectors.toList()
        List<Person> personsEverWorkedInEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().stream()
                        .anyMatch(job -> job.getCompany().equals("EPAM")))
                .map(Employee::getPerson).collect(Collectors.toList());

        System.out.println("These people ever worked in EPAM: " + personsEverWorkedInEpam + "\n");

//        personsEverWorkedInEpam - should contain employees.get(0),  employees.get(1),
//                employees.get(4), employees.get(5)
    }

    void findPersonsBeganCareerInEpam() {
        List<Employee> employees = getEmployees();

        // TODO реализация, использовать Collectors.toList()
        List<Person> startedFromEpam = employees.stream()
                .filter(employee -> employee.getJobHistory()
                        .stream().findFirst().get().getCompany().equals("EPAM"))
                .map(Employee::getPerson).collect(Collectors.toList());

        System.out.println("These people started a career in EPAM: " + startedFromEpam + "\n");

//        startedFromEpam - should contain
//                employees.get(0).getPerson(),
//                employees.get(1).getPerson(),
//                employees.get(4).getPerson()
    }

    void findAllCompanies() {
        List<Employee> employees = getEmployees();

        // TODO реализация, использовать Collectors.toSet()
        Set<String> companies = employees.stream()
                .flatMap(employee -> employee.getJobHistory().stream().map(JobHistoryEntry::getCompany))
                .collect(Collectors.toSet());

        System.out.println("This is all companies list: " + companies + "\n");
//        companies - should contain "EPAM", "google", "yandex", "mail.ru", "T-Systems"
    }

    void findMinimalAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        // TODO реализация
        Integer minimalAge = employees.stream()
                .min((employee1, employee2) -> {
                    Integer age1 = employee1.getPerson().getAge();
                    Integer age2 = employee2.getPerson().getAge();
                    return age1.compareTo(age2);
                })
                .map(e -> e.getPerson().getAge())
                .get();

        System.out.println("Minimal age is: " + minimalAge + "\n");

        // minmalAge = 21
    }

    // Посчитать средний возраст работников
    void calcAverageAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Double expected = employees.stream()
                .collect(Collectors.averagingDouble(e -> e.getPerson().getAge()));

        System.out.println("Average age of employees: " + expected + "\n");

    }

    // Найти Person с самым длинным fullName
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

    // Найти работника с самой большой продолжительность на одной же позиции
    void findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = getEmployees();

        Employee expected = employees.stream()
                .max((employee1, employee2) -> {
                    Integer time1 = 0;
                    for (int i = 0; i < employee1.getJobHistory().size(); i++) {
                        if (employee1.getJobHistory().get(i).getDuration() > time1) {
                            time1 = employee1.getJobHistory().get(i).getDuration();
                        }
                    }
                    int time2 = 0;
                    for (int i = 0; i < employee2.getJobHistory().size(); i++) {
                        if (employee2.getJobHistory().get(i).getDuration() > time2) {
                            time2 = employee2.getJobHistory().get(i).getDuration();
                        }
                    }
                    return time1.compareTo(time2);
                })
                .get();

        System.out.println("The employee with the biggest experience in one position" + expected);
    }
}

