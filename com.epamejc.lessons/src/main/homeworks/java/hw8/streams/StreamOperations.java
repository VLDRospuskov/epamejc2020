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
                .filter(e -> {
                    List<JobHistoryEntry> list = e.getJobHistory();
                    for(JobHistoryEntry l : list) {
                        if (l.getCompany().equals("EPAM")) {
                            return true;
                        }
                    }
                    return false;
                })
                .map(e -> e.getPerson())
                .collect(Collectors.toList());
        System.out.println(personsEverWorkedInEpam);

//        personsEverWorkedInEpam - should contain employees.get(0),  employees.get(1),
//                employees.get(4), employees.get(5)
    }

    void findPersonsBeganCareerInEpam() {
        List<Employee> employees = getEmployees();

        // TODO реализация, использовать Collectors.toList()
        List<Person> startedFromEpam = employees.stream()
                .filter(e -> {
                    List<JobHistoryEntry> list = e.getJobHistory();
                        if (list.get(0).getCompany().equals("EPAM")) {
                            return true;
                        }
                    return false;
                })
                .map(e -> e.getPerson())
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
                .map(e -> e.getJobHistory())
                .flatMap(persons -> persons.stream())
                .map(company -> company.getCompany())
                .collect(Collectors.toSet());
        System.out.println(companies);

//        companies - should contain "EPAM", "google", "yandex", "mail.ru", "T-Systems"
    }

    void findMinimalAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        // TODO реализация

        Integer minimalAge = employees.stream()
                .min((p1, p2) -> {
                    Integer i1 = p1.getPerson().getAge();
                    Integer i2 = p2.getPerson().getAge();
                        return i1.compareTo(i2); } )
                .map(e -> e.getPerson().getAge())
                .get();
        System.out.println(minimalAge);
        // minmalAge = 21
    }

    // Посчитать средний возраст работников
    void calcAverageAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Double expected = employees.stream()
                .collect(Collectors.averagingDouble(e -> e.getPerson().getAge()));
        System.out.println(expected);

    }

    // Найти Person с самым длинным fullName
    void findPersonWithLongestFullName() {
        List<Employee> employees = getEmployees();

        Person expected = employees.stream()
                .map(e -> e.getPerson())
                .max((p1, p2) -> {
                    Integer i1 = p1.getFirstName().length() + p1.getLastName().length();
                    Integer i2 = p2.getFirstName().length() + p2.getLastName().length();
                    return i1.compareTo(i2); } )
                .get();
        System.out.println(expected);
    }

    // Найти работника с самой большой продолжительность на одной же позиции
    void findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = getEmployees();

        Employee expected = null;

    }

}
