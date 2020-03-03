package homeworks.homework01;

import org.junit.Assert;
import org.junit.Test;

public class ImmutableGirlTest {
    ImmutableGirl someGirl = new ImmutableGirl(18, "Sasha");

    @Test
    public void TestImmutable() {
        String expected = someGirl.getName() + someGirl.getAge() + someGirl.getMood().getMoodState();

        int age = someGirl.getAge();
        String name = someGirl.getName();
        MutableMood mood = someGirl.getMood();

        age = 16;
        name = "Anatoliy";
        mood.setMoodState("sad");

        String actual = someGirl.getName() + someGirl.getAge() + someGirl.getMood().getMoodState();

        Assert.assertEquals(expected, actual);
    }

}
