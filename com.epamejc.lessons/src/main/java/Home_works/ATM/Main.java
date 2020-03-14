package Home_works.ATM;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final ATM atm1 = new ATM(1, new BigDecimal("100"));
        final ATM atm2 = new ATM(2, new BigDecimal("100000"));
        final ATM atm3 = new ATM(3, new BigDecimal("345678"));

        ATM.setCommonBalance(new BigDecimal("1000000000000"));

        final User vladimir = new User("Vladimir", new BigDecimal("1000000"));
        final User boris = new User("Boris", new BigDecimal("1000000"));
        final User dmitrii = new User("Dmitrii", new BigDecimal("1000000"));
        final User maria = new User("Maria", new BigDecimal("1000000"));

        List<ATM> listOfATMs = new ArrayList<>();
        listOfATMs.add(atm1);
        listOfATMs.add(atm2);
        listOfATMs.add(atm3);


        List<User> users = new ArrayList<>();
        users.add(vladimir);
        users.add(boris);
        users.add(dmitrii);
        users.add(maria);

        ThreadATMOperations.listOfUsers = users;

        final ThreadATMOperations threadATMOperations = new ThreadATMOperations(atm1, vladimir);
        final ThreadATMOperations threadATMOperations1 = new ThreadATMOperations(atm2, boris);
        final ThreadATMOperations threadATMOperations2 = new ThreadATMOperations(atm3, dmitrii);
        final ThreadATMOperations threadATMOperations3 = new ThreadATMOperations(atm1, maria);

        threadATMOperations.start();
        threadATMOperations1.start();
        threadATMOperations2.start();
        threadATMOperations3.start();
    }
}
