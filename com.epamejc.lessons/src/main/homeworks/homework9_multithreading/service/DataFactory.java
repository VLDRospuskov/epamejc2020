package homeworks.homework9_multithreading.service;

import homeworks.homework9_multithreading.model.ATM;
import homeworks.homework9_multithreading.model.Account;
import homeworks.homework9_multithreading.model.Person;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class DataFactory {
    public List<Account> getAccounts(List<Person> persons) {
        return persons
                .stream()
                .map(this::getAccount)
                .collect(Collectors.toList());
    }

    public List<Person> getPersons() {
        String[] names = {"Aleksey", "Vadim", "Anna", "Oleg", "Fedor", "Oksana", "Boris", "Igor"};
        return Arrays
                .stream(names)
                .map(this::getPerson)
                .collect(Collectors.toList());
    }

    public List<ATMOperations> getATMoperations(ATM atm, List<Person> personList) {
        return personList
                .stream()
                .map((Person person) -> new ATMOperations(person, atm))
                .collect(Collectors.toList());
    }

    private Account getAccount(Person person) {
        Random random = new Random();
        long card = person.getCard();
        BigDecimal balance = new BigDecimal(random.nextInt(1000));
        return new Account(card, balance);
    }

    private Person getPerson(String name) {
        Random random = new Random();
        long card = random.nextLong();
        return new Person(name, card);
    }
}
