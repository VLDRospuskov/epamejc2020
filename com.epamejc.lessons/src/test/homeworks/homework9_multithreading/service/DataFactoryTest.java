package homeworks.homework9_multithreading.service;

import homeworks.homework9_multithreading.model.ATM;
import homeworks.homework9_multithreading.model.Account;
import homeworks.homework9_multithreading.model.Bank;
import homeworks.homework9_multithreading.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DataFactoryTest {
    private DataFactory factory;
    private List<Person> persons;
    private List<Account> accounts;
    private int size = 8;
    private static final String ALEKSEY = "Aleksey";
    private static final String IGOR = "Igor";
    private int pSize = 8;
    private int aSize = 8;

    @Before
    public void setUp() {
        factory = new DataFactory();
        persons = factory.getPersons();
        accounts = factory.getAccounts(persons);
    }

    @Test
    public void testGetPersons() {

        assertNotNull(persons);
        assertEquals(size, persons.size());
        assertNotNull(persons.get(0));
        assertNotNull(persons.get(pSize - 1));
        assertEquals(ALEKSEY, persons.get(0).getName());
        assertEquals(IGOR, persons.get(pSize - 1).getName());
    }

    @Test
    public void testGetAccounts() {

        assertNotNull(accounts);
        assertEquals(size, accounts.size());
        assertEquals(persons.get(0).getCard(), accounts.get(0).getCard());
        assertEquals(persons.get(pSize - 1).getCard(), accounts.get(aSize - 1).getCard());
    }

    @Test
    public void testGetATMoperations() {

        Bank bank = new Bank(new BigDecimal(100), accounts);
        ATM atm = new ATM("Stachek", new BigDecimal(10), bank);
        List<ATMOperations> atMoperations = factory.getATMoperations(atm, persons);

        assertNotNull(atMoperations);
        assertEquals(size, atMoperations.size());

    }
}