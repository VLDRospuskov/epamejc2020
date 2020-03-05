package homework8.task2;


@SuppressWarnings({"unused"})
public class Main {

    public static void main(String[] args) {
        StreamOperations streamOperations = new StreamOperations();

        streamOperations.findPersonsEverWorkedInEpam();
        streamOperations.findPersonsBeganCareerInEpam();
        streamOperations.findAllCompanies();
        streamOperations.findMinimalAgeOfEmployees();
        streamOperations.calcAverageAgeOfEmployees();
        streamOperations.findPersonWithLongestFullName();
        streamOperations.findEmployeeWithMaximumDurationAtOnePosition();
    }
}
