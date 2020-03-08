package homeworks.homework9_multithreading.service;

import homeworks.homework9_multithreading.model.ATM;
import homeworks.homework9_multithreading.model.Account;
import homeworks.homework9_multithreading.model.Bank;
import homeworks.homework9_multithreading.model.Person;

import java.math.BigDecimal;
import java.util.List;

public class BankOperations implements Runnable{
    @Override
    public void run() {
        DataFactory factory = new DataFactory();
        List<Person> people = factory.getPersons();
        List<Account> accounts = factory.getAccounts(people);
        Bank Tinkoff = new Bank(new BigDecimal(9999999999.2121),accounts);
        BigDecimal startBalance = new BigDecimal(7000);

        ATM stachek = new ATM("Stachek",startBalance,Tinkoff);
        ATM nevsky = new ATM("Nevsky",startBalance,Tinkoff);
        ATM moskovsky = new ATM("Moskovsky",startBalance,Tinkoff);
        ATM primorsky = new ATM("Primorsky",startBalance,Tinkoff);

        List<ATMOperations> stachekOp = factory.getATMoperations(stachek,people);
        List<ATMOperations> nevskyOp = factory.getATMoperations(nevsky,people);
        List<ATMOperations> moskovskyOp = factory.getATMoperations(moskovsky,people);
        List<ATMOperations> primorskyOp = factory.getATMoperations(primorsky,people);

        stachekOp.forEach(Thread::start);
        nevskyOp.forEach(Thread::start);
        moskovskyOp.forEach(Thread::start);
        primorskyOp.forEach(Thread::start);

    }
}
