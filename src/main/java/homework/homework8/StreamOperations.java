package homework.homework8;

import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static homework.homework8.GenerateData.getEmployees;


@SuppressWarnings({"unused"})
public class StreamOperations {

    List<Person> findPersonsEverWorkedInEpam() {
        List<Employee> employees = getEmployees();

        // TODO реализация, использовать Collectors.toList()
        List<Person> personsEverWorkedInEpam = employees.stream()
                .filter(employee -> employee.getJobHistory()
                                            .stream()
                                            .anyMatch(history -> history.getCompany().equals("EPAM"))
                        )
                .map(Employee::getPerson)
                .collect(Collectors.toList());

        return personsEverWorkedInEpam; //что возвращать то? расходится List<Person> personsEverWorkedInEpam
                                        // и название метода с результатом ниже,
                                        // который предполагает получение List<Employee>

//        personsEverWorkedInEpam - should contain employees.get(0),  employees.get(1),
//                employees.get(4), employees.get(5)
    }

    List<Person> findPersonsBeganCareerInEpam() {
        List<Employee> employees = getEmployees();

        // TODO реализация, использовать Collectors.toList()
        List<Person> startedFromEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().get(0).getCompany().equals("EPAM"))
                .map(Employee::getPerson)
                .collect(Collectors.toList());

        return startedFromEpam;
//        startedFromEpam - should contain
//                employees.get(0).getPerson(),
//                employees.get(1).getPerson(),
//                employees.get(4).getPerson()
    }

    Set findAllCompanies() {
        List<Employee> employees = getEmployees();

        // TODO реализация, использовать Collectors.toSet()
        Set<String> companies = employees.stream()
                .map(Employee::getJobHistory)
                .flatMap(histories -> histories.stream())
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
                .get();

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
                .getAsDouble();

        return expected;
    }

    // Найти Person с самым длинным fullName
    Person findPersonWithLongestFullName() {
        List<Employee> employees = getEmployees();

        Person expected = employees.stream()
                .map(Employee::getPerson)
                .reduce((person1, person2) -> person1.getLastName().length() > person2.getLastName().length() ?
                        person1 : person2)
                .get();

        return expected;
    }

    // Найти работника с самой большой продолжительность на одной же позиции
    Employee findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = getEmployees();

        Employee expected = employees.stream()
                .reduce(new BinaryOperator<Employee>() {
                    @Override
                    public Employee apply(Employee employee1, Employee employee2) {
                        int max1 =  employee1.getJobHistory()
                                .stream()
                                .mapToInt(JobHistoryEntry::getDuration)
                                .max()
                                .getAsInt();
                        int max2 = employee2.getJobHistory()
                                .stream()
                                .mapToInt(JobHistoryEntry::getDuration)
                                .max()
                                .getAsInt();
                        return max1 > max2 ? employee1 : employee2;
                    }
                })
                .get();

        return expected;
    }
}
