package Home_works.HW_8_part_2;

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
