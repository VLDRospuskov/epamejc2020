package homeworks.java.java8.part2;

import java.util.List;
import java.util.Set;

@SuppressWarnings({"unused"})
public class Main {

    public static void main(String[] args) {
        StreamOperations streamOperations = new StreamOperations();
        List<Person> personsEverWorkedInEpam = streamOperations.findPersonsEverWorkedInEpam();
        List<Person> startedFromEpam = streamOperations.findPersonsBeganCareerInEpam();
        Set<String> companies = streamOperations.findAllCompanies();
        Integer minimalAge = streamOperations.findMinimalAgeOfEmployees();
        Double averageAge = streamOperations.calcAverageAgeOfEmployees();
        Person longestFullName = streamOperations.findPersonWithLongestFullName();
        Employee maximumDurationAtOnePosition = streamOperations.findEmployeeWithMaximumDurationAtOnePosition();

        System.out.println(personsEverWorkedInEpam);
        System.out.println(startedFromEpam);
        System.out.println(companies);
        System.out.println(minimalAge);
        System.out.println(averageAge);
        System.out.println(longestFullName);
        System.out.println(maximumDurationAtOnePosition);

    }

}