package homeworks.java.hw8.streamOperations;

public class Main {

    public static void main(String[] args) {
        StreamOperations streamOperations = new StreamOperations();

        streamOperations.findPersonsBeganCareerInEpam();
        streamOperations.findPersonsEverWorkedInEpam();
        streamOperations.findAllCompanies();
        streamOperations.findMinimalAgeOfEmployees();
        streamOperations.calcAverageAgeOfEmployees();
        streamOperations.findPersonWithLongestFullName();
        streamOperations.findEmployeeWithMaximumDurationAtOnePosition();
    }

}
