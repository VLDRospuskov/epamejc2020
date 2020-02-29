package homeworks.HW8_functionalAndStream.streamOperations;

@SuppressWarnings({"unused"})
public class Main {

    public static void main(String[] args) {
        StreamOperations streamOperations = new StreamOperations();
        streamOperations.findAllCompanies();
        streamOperations.findPersonsBeganCareerInEpam();
        streamOperations.findPersonsEverWorkedInEpam();
        streamOperations.findMinimalAgeOfEmployees();
        streamOperations.calcAverageAgeOfEmployees();
        streamOperations.findPersonWithLongestFullName();
        streamOperations.findEmployeeWithMaximumDurationAtOnePosition();
    }

}