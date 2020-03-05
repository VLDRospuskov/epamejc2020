package homework9.task1;


import HomeworksReaderAndPrinter.ConsoleReader;
import HomeworksReaderAndPrinter.Reader;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class MultiThreadingTask1Main {

    static List<User> users = new ArrayList<>(5);
    static List<ATM> atms = new ArrayList<>(5);
    static int numberOfOperations = launcher(new ConsoleReader());

    @SneakyThrows
    private static int launcher(Reader reader) {
        System.out.println("Enter amount of operations which every person will do: ");
        int amountOfOperations = Integer.parseInt(reader.read());
        reader.close();
        return amountOfOperations;
    }

    @SneakyThrows
    public static void main(String[] args) {
        users.add(new User("Vanya"));
        users.add(new User("Grisha"));
        users.add(new User("Vasya"));
        users.add(new User("Masha"));
        users.add(new User("Katya"));

        atms.add(new ATM(1));
        atms.add(new ATM(2));
        atms.add(new ATM(3));
        atms.add(new ATM(4));
        atms.add(new ATM(5));

        System.out.println("---------------------------------------------------------------");

        final ThreadOperationsATM threadATMOperations = new ThreadOperationsATM(users.get(0));
        final ThreadOperationsATM threadATMOperations1 = new ThreadOperationsATM(users.get(1));
        final ThreadOperationsATM threadATMOperations2 = new ThreadOperationsATM(users.get(2));
        final ThreadOperationsATM threadATMOperations3 = new ThreadOperationsATM(users.get(3));
        final ThreadOperationsATM threadATMOperations4 = new ThreadOperationsATM(users.get(4));

        threadATMOperations.start();
        threadATMOperations1.start();
        threadATMOperations2.start();
        threadATMOperations3.start();
        threadATMOperations4.start();
    }
}
