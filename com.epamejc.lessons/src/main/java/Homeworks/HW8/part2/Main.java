package Homeworks.HW8.part2;

@SuppressWarnings({"unused"})
public class Main {

    public static void main(String[] args) {
        StreamOperations streamOperations = new StreamOperations();
        streamOperations.findAllCompanies();
        streamOperations.findMinimalAgeOfEmployees();
        streamOperations.calcAverageAgeOfEmployees();
        streamOperations.findPersonsEverWorkedInEpam();
        streamOperations.findPersonsBeganCareerInEpam();
        streamOperations.findPersonWithLongestFullName();
        streamOperations.findEmployeeWithMaximumDurationAtOnePosition();
    }

}