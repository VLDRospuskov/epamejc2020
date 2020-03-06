package homework.ConcurrencyATM;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {

        final ATM atm = new ATM(0, new BigDecimal("100"));
        final ATM atm1 = new ATM(1, new BigDecimal("250000"));
        final ATM atm2 = new ATM(2, new BigDecimal("500000"));
        final ATM atm3 = new ATM(3, new BigDecimal("50000"));
        final ATM atm4 = new ATM(4, new BigDecimal("700000"));

        ATM.setCommonBalance(new BigDecimal("7000000"));

        List<ATM> atms = new ArrayList<>();
        atms.add(atm);
        atms.add(atm1);
        atms.add(atm2);
        atms.add(atm3);
        atms.add(atm4);

        final User vladimir = new User("Vladimir", new BigDecimal("1000000"));
        final User boris = new User("Boris", new BigDecimal("1000000"));
        final User dmitrii = new User("Dmitrii", new BigDecimal("1000000"));
        final User olga = new User("Olga", new BigDecimal("1000000"));
        final User oleg = new User("Oleg", new BigDecimal("1000000"));
        final User gleb = new User("Gleb", new BigDecimal("1000000"));
        final User maria = new User("Maria", new BigDecimal("1000000"));

        List<User> users = new ArrayList<>();
        users.add(vladimir);
        users.add(boris);
        users.add(dmitrii);
        users.add(olga);
        users.add(oleg);
        users.add(gleb);
        users.add(maria);

        ThreadATMOperations.users = users;

        new Thread(() -> {
            while (true) {
                try {
                    sleep(new Random().nextInt(2000));
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                for (ATM atmloop : atms) {
                    if (atmloop.getATMBalance().compareTo(new BigDecimal("10000")) < 0) {
                        if (ATM.getCommonBalance().compareTo(new BigDecimal(10000)) < 0) {
                            atmloop.setATMBalance(atmloop.getATMBalance().add(ATM.getCommonBalance()));
                            System.out.printf("Inquisitors came to atm #%d and with God's power added all the money they had (%s) to it\n",
                                    atmloop.getID(), ATM.getCommonBalance());
                            ATM.setCommonBalance(new BigDecimal(0));
                        } else {
                            atmloop.setATMBalance(atmloop.getATMBalance().add(new BigDecimal("10000")));
                            ATM.setCommonBalance(ATM.getCommonBalance().subtract(new BigDecimal(10000)));
                            System.out.printf("Inquisitors came to atm #%d and added 10000 to it\n", atmloop.getID());
                        }
                    } else if (atmloop.getATMBalance().compareTo(new BigDecimal(1000000)) > 0) {
                        ATM.setCommonBalance(ATM.getCommonBalance().add(atmloop.getATMBalance().subtract(new BigDecimal(1000000))));
                        System.out.printf("Inquisitors came to atm #%d and took %s from it\n",
                                atmloop.getID(),
                                atmloop.getATMBalance().subtract(new BigDecimal(1000000)));
                        atmloop.setATMBalance(new BigDecimal(1000000));
                    }
                }
            }
        }).start();

        final ThreadATMOperations threadATMOperations = new ThreadATMOperations(atm, vladimir);
        final ThreadATMOperations threadATMOperations1 = new ThreadATMOperations(atm1, boris);
        final ThreadATMOperations threadATMOperations12 = new ThreadATMOperations(atm2, boris);
        final ThreadATMOperations threadATMOperations2 = new ThreadATMOperations(atm4, dmitrii);
        final ThreadATMOperations threadATMOperations3 = new ThreadATMOperations(atm3, olga);
        final ThreadATMOperations threadATMOperations4 = new ThreadATMOperations(atm3, oleg);
        final ThreadATMOperations threadATMOperations5 = new ThreadATMOperations(atm1, gleb);
        final ThreadATMOperations threadATMOperations6 = new ThreadATMOperations(atm, maria);

        threadATMOperations.start();
        threadATMOperations1.start();
        threadATMOperations12.start();
        threadATMOperations2.start();
        threadATMOperations3.start();
        threadATMOperations4.start();
        threadATMOperations5.start();
        threadATMOperations6.start();

    }
}