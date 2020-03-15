package main.homeworks.homework8.part2;

@SuppressWarnings({"unused"})
public class Main {

    public static void main(String[] args) {
        StreamOperations streamOperations = new StreamOperations();
        streamOperations.findPersonsEverWorkedInEpam();
        streamOperations.findPersonsBeganCareerInEpam();
        streamOperations.findMinimalAgeOfEmployees();
        streamOperations.calcAverageAgeOfEmployees();
        streamOperations.findPersonWithLongestFullName();
        streamOperations.findEmployeeWithMaximumDurationAtOnePosition();
        streamOperations.findAllCompanies();
    }

}