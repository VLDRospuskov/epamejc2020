package homeworks.java.immutableClass;


import org.junit.Test;
import org.mutabilitydetector.unittesting.MutabilityAssert;

public class ImmutableClassTest {

    @Test
    public void immutabilityTest() {
        MutabilityAssert.assertImmutable(Immutable.class);
    }

    @Test(expected = org.mutabilitydetector.unittesting.MutabilityAssertionError.class)
    public void notImmutabilityTest() {
        MutabilityAssert.assertImmutable(NotImmutable.class);
    }
}
