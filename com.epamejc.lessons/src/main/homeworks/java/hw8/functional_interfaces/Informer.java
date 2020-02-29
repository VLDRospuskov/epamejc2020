package homeworks.java.hw8.functional_interfaces;

public class Informer {

    public void run() {
        Person person = new Person(65000, "Ivan Kolobkov");

        MyProducer<Integer> takeSalary = () -> person.getSalary();
        MyProducer<String> takeName = () -> person.getName();
        MyBiFunction<Integer, String, String> buildStr = (num, str) -> "Dear Mr. "
                + str + "! We inform you that your salary has been increased to " + num + " USD.";

        String output = getStringFromFields(takeSalary, takeName, buildStr);
        System.out.println(output);
    }

    private String getStringFromFields(MyProducer<Integer> takeSalary, MyProducer<String> takeName, MyBiFunction<Integer, String, String> func) {
        int salary = takeSalary.produce();
        String name = takeName.produce();
        String output = func.apply(salary, name);
        return output;
    }

}
