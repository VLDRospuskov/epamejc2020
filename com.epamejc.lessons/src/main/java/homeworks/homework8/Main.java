package homeworks.homework8;

@SuppressWarnings({"unused"})
public class Main {
    
    public static void main(String[] args) {
        StreamOperations streamOperations = new StreamOperations();
        System.out.println(streamOperations.findPersonWithLongestFullName());
        System.out.println(streamOperations.findPersonsBeganCareerInEpam());
        System.out.println(streamOperations.findAllCompanies());
        System.out.println(streamOperations.findMinimalAgeOfEmployees());
        System.out.println(streamOperations.calcAverageAgeOfEmployees());
        System.out.println(streamOperations.findEmployeeWithMaximumDurationAtOnePosition());
        System.out.println(streamOperations.findPersonsEverWorkedInEpam());
    }
    
}