package homeworks.java.multithreading;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BankTest {

    @Before
    public void setUp() {

        Bank.getInstance().deleteAllUsers();

    }

    @Test
    public void testRegisterDifferentUsers() {
        User user1 = new User("Tom", 100, 100);
        User user2 = new User("Jerry", 200, 200);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        Bank.getInstance().registerUsers(users);

        Assert.assertEquals(2, Bank.getInstance().getUserAccounts().size());
    }

    @Test
    public void testRegisterEqualUsers () {

        User user1 = new User("Harold", 300, 300);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user1);

        Bank.getInstance().registerUsers(users);

        Assert.assertEquals(1, Bank.getInstance().getUserAccounts().size());

    }

    @Test
    public void testGetUserAccountDetailsExistingUser() {

    }

    @Test
    public void testGetUserAccountDetailsMissingUser() {

    }

}
