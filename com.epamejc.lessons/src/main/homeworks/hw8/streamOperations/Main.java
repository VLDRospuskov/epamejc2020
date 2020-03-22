package main.homeworks.hw8.streamOperations;

@SuppressWarnings({"unused"})
public class Main {

    public static void main(String[] args) {
        StreamOperations streamOperations = new StreamOperations();
        streamOperations.findAllCompanies();
        streamOperations.findPersonsEverWorkedInEpam();
        streamOperations.findPersonsBeganCareerInEpam();
        streamOperations.findMinimalAgeOfEmployees();
        streamOperations.findPersonWithLongestFullName();
        streamOperations.calcAverageAgeOfEmployees();
        streamOperations.findEmployeeWithMaximumDurationAtOnePosition();
    }

}