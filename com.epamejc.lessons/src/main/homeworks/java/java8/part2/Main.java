package homeworks.java.java8.part2;

/**
 * The goal is to update {@link StreamOperations} class using streams so that program works correctly.
 *
 * @author Vladimir Ivanov
 */
public class Main {

    public static void main(String[] args) {

        StreamOperations streamOperations = new StreamOperations();

        System.out.println(streamOperations.findPersonsEverWorkedInEpam());
        System.out.println(streamOperations.findPersonsBeganCareerInEpam());
        System.out.println(streamOperations.findAllCompanies());
        System.out.println(streamOperations.findMinimalAgeOfEmployees());
        System.out.println(streamOperations.calcAverageAgeOfEmployees());
        System.out.println(streamOperations.findPersonWithLongestFullName());
        System.out.println(streamOperations.findEmployeeWithMaximumDurationAtOnePosition());

    }

}