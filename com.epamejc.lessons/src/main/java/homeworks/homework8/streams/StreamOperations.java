package homeworks.homework8.streams;

import java.util.*;
import java.util.stream.Collectors;

import static homeworks.homework8.streams.GenerateData.getEmployees;

@SuppressWarnings({"unused"})
public class StreamOperations {
    
    List<Person> findPersonsEverWorkedInEpam() {
        List<Employee> employees = getEmployees();
        Person person;
        
        return employees.stream()
                        .filter(employee -> employee.getJobHistory()
                                                    .stream()
                                                    .anyMatch(jobHistoryEntry -> jobHistoryEntry.getCompany()
                                                                                                .equals("EPAM")))
                        .map(Employee::getPerson)
                        .collect(Collectors.toList());
    }
    
    List<Person> findPersonsBeganCareerInEpam() {
        List<Employee> employees = getEmployees();
        
        return employees.stream()
                        .filter(employee -> employee.getJobHistory()
                                                    .get(0)
                                                    .getCompany()
                                                    .equals("EPAM"))
                        .map(Employee::getPerson)
                        .collect(Collectors.toList());
    }
    
    Set<String> findAllCompanies() {
        List<Employee> employees = getEmployees();
        
        return employees.stream()
                        .map(employee -> employee.getJobHistory()
                                                 .stream()
                                                 .map(JobHistoryEntry::getCompany)
                                                 .collect(Collectors.toSet()))
                        .flatMap(Collection::stream)
                        .collect(Collectors.toSet());
    }
    
    Integer findMinimalAgeOfEmployees() {
        List<Employee> employees = getEmployees();
        
        return employees.stream()
                        .mapToInt(employee -> employee.getPerson()
                                                      .getAge())
                        .min()
                        .orElseThrow(NoSuchElementException::new);
    }
    
    Double calcAverageAgeOfEmployees() {
        List<Employee> employees = getEmployees();
        
        return employees.stream()
                        .mapToInt(employee -> employee.getPerson()
                                                      .getAge())
                        .average()
                        .orElseThrow(NoSuchElementException::new);
        
    }
    
    Person findPersonWithLongestFullName() {
        List<Employee> employees = getEmployees();
        
        return employees.stream()
                        .map(Employee::getPerson)
                        .max(Comparator.comparingInt(person -> person.getFirstName()
                                                                     .length() + person.getLastName()
                                                                                       .length()))
                        .orElseThrow(NoSuchElementException::new);
    }
    
    Employee findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = getEmployees();
        
        return employees.stream()
                        .max(Comparator.comparingInt(
                                employee -> employee.getJobHistory()
                                                    .stream()
                                                    .map(JobHistoryEntry::getDuration)
                                                    .max(Integer::compareTo)
                                                    .orElseThrow(
                                                            NoSuchElementException::new)))
                        .orElseThrow(NoSuchElementException::new);
    }
    
}
