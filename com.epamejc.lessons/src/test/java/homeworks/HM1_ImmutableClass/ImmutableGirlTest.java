package homeworks.HM1_ImmutableClass;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class ImmutableGirlTest {
    ImmutableGirl someGirl = new ImmutableGirl(18, "Sasha");

    @Test
    public void TestImmutable() {
        int[] expected = {someGirl.getAge(), someGirl.getName().length(), someGirl.getClothes().size()};

        int age = someGirl.getAge();
        String name = someGirl.getName();
        Stack<String> undressTry = someGirl.getClothes();

        age = 16;
        name = "Anatoliy";
        undressTry.pop();

        int[] actual = {someGirl.getAge(), someGirl.getName().length(), someGirl.getClothes().size()};

        Assert.assertArrayEquals(expected, actual);
    }

}
