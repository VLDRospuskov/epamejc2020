package homeworks.HW_8_Java8.streamOperations;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static homeworks.HW_8_Java8.streamOperations.GenerateData.getEmployees;

@SuppressWarnings({"unused"})
public class StreamOperations {
    public List<Employee> employees = getEmployees();

    public List<Person> findPersonsEverWorkedInEpam() {
        return employees.stream()
                .filter(employee -> employee.getJobHistory().stream()
                        .anyMatch(JobHistory -> JobHistory.getCompany().equals("EPAM")))
                .map(Employee::getPerson)
                .collect(Collectors.toList());
    }

    public List<Person> findPersonsBeganCareerInEpam() {
        return employees.stream()
                .filter(employee -> employee.getJobHistory()
                        .get(0).getCompany().equals("EPAM"))
                .map(Employee::getPerson)
                .collect(Collectors.toList());
    }

    public Set<String> findAllCompanies() {
        return employees.stream()
                .flatMap(employee -> employee.getJobHistory().stream()
                        .map(JobHistoryEntry::getCompany)
                        .distinct())
                .collect(Collectors.toSet());
    }

    public Integer findMinimalAgeOfEmployees() {
        return employees.stream()
                .mapToInt(employee -> employee.getPerson().getAge())
                .min()
                .orElse(-1);
    }

    // Посчитать средний возраст работников
    public Double calcAverageAgeOfEmployees() {
        return employees.stream()
                .mapToInt(employee -> employee.getPerson().getAge())
                .average()
                .orElse(-1.0);
    }

    // Найти Person с самым длинным fullName
    public Person findPersonWithLongestFullName() {
        return employees.stream()
                .map(Employee::getPerson)
                .max(Comparator.comparingInt(person -> person.getLastName().length()
                        + person.getFirstName().length()))
                .orElse(new Person("Ошибка", "Ошибка", 0));
    }

    // Найти работника с самой большой продолжительность на одной же позиции
    public Employee findEmployeeWithMaximumDurationAtOnePosition() {
        return employees.stream()
                .max(Comparator.comparingInt(employee -> employee.getJobHistory().stream()
                        .max(Comparator.comparingInt(JobHistoryEntry::getDuration))
                        .orElse(employees.get(0).getJobHistory().get(0))
                        .getDuration()))
                .orElse(employees.get(0));
    }

}
