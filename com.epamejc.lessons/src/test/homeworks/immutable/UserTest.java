package homeworks.immutable;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    private User user;
    String name = "Ivan";
    int age = 12;
    @Before
    public void setUp(){
        user = new User(name,age);
    }

    @Test
    public void getName() {
        assertEquals(name,user.getName());
    }

    @Test
    public void getAge() {
        assertEquals(age,user.getAge());
    }
}