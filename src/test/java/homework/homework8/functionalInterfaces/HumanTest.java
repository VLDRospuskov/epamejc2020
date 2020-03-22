package homework.homework8.functionalInterfaces;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanTest {

    private Human human;

    private Getter<String> nameGetter;
    private Getter<Integer> ageGetter;
    private Handler<String, Integer, String> handler;

    @Before
    public void setup(){
        nameGetter = () -> human.getName();
        ageGetter = () -> human.getAge();
        handler = (name, age) -> String.format(
                "My name is %1$s and I'm %2$d years old", name, age);
    }

    @Test
    public void formInfo() {
        human = new Human();
        human.setName("Yana");
        human.setAge(24);

        String expected = String.format(
                "My name is %1$s and I'm %2$d years old", human.getName(), human.getAge());

        assertEquals(expected, human.formInfo(nameGetter, ageGetter, handler));

        human = new Human();
        human.setName("Anya");
        human.setAge(10);

        expected = String.format(
                "My name is %1$s and I'm %2$d years old", human.getName(), human.getAge());

        assertEquals(expected, human.formInfo(nameGetter, ageGetter, handler));
    }
}