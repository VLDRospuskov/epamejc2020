package com.epamejc.lessons.src.homework.homework8.java8.streams;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static com.epamejc.lessons.src.homework.homework8.java8.streams.GenerateData.getEmployees;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StreamOperationsTest {
    StreamOperations streamOperations = new StreamOperations();
    List<Employee> employees = getEmployees();

    @Test
    public void findPersonsEverWorkedInEpam() {
        List<Person> persons = streamOperations.findPersonsEverWorkedInEpam();
        int count = 0;
        for (Employee employee : employees) {
            List<JobHistoryEntry> jobs = employee.getJobHistory();
            for (JobHistoryEntry job : jobs) {
                if (job.getCompany().equals("EPAM")) {
                    assertTrue(persons.contains(employee.getPerson()));
                    count++;
                    break;
                }
            }
        }
        assertEquals(count, persons.size());
    }

    @Test
    public void findPersonsBeganCareerInEpam() {
        List<Person> persons = streamOperations.findPersonsBeganCareerInEpam();
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getJobHistory().size() > 0
                    && employee.getJobHistory().get(0).getCompany().equals("EPAM")) {
                assertTrue(persons.contains(employee.getPerson()));
                count++;
            }
        }
        assertEquals(count, persons.size());
    }

    @Test
    public void findAllCompanies() {
        Set<String> companies = streamOperations.findAllCompanies();
        for (Employee employee : employees) {
            for (JobHistoryEntry job : employee.getJobHistory()) {
                assertTrue(companies.contains(job.getCompany()));
            }
        }
    }

    @Test
    public void findMinimalAgeOfEmployees() {
        Integer minimal = streamOperations.findMinimalAgeOfEmployees();
        Integer foundedMinimal = employees.get(0).getPerson().getAge();
        for (Employee employee : employees) {
            foundedMinimal = Math.min(foundedMinimal, employee.getPerson().getAge());
        }
        assertEquals(foundedMinimal, minimal);
    }

    @Test
    public void calcAverageAgeOfEmployees() {
        Double average = streamOperations.calcAverageAgeOfEmployees();
        Double sum = 0.0;
        for (Employee employee : employees) {
            sum += employee.getPerson().getAge();
        }
        Double calculatedAverage = sum / employees.size();
        assertEquals(calculatedAverage, average);
    }

    @Test
    public void findPersonWithLongestFullName() {
        Person person = streamOperations.findPersonWithLongestFullName();
        Person foundedPerson = employees.get(0).getPerson();
        String foundedName = employees.get(0).getPerson().getFirstName() + employees.get(0).getPerson().getLastName();
        for (Employee employee : employees) {
            String fullName = employee.getPerson().getFirstName() + employee.getPerson().getLastName();
            if (fullName.length() > foundedName.length()) {
                foundedName = fullName;
                foundedPerson = employee.getPerson();
            }
        }
        assertEquals(foundedPerson, person);
    }

    @Test
    public void findEmployeeWithMaximumDurationAtOnePosition() {
        Person person = streamOperations.findEmployeeWithMaximumDurationAtOnePosition();
        int maxDuration = -1;
        Person foundedPerson = employees.get(0).getPerson();
        for (Employee employee : employees) {
            for (JobHistoryEntry job : employee.getJobHistory()) {
                if (maxDuration < job.getDuration()) {
                    maxDuration = job.getDuration();
                    foundedPerson = employee.getPerson();
                }
            }
        }
        assertEquals(foundedPerson, person);
    }
}