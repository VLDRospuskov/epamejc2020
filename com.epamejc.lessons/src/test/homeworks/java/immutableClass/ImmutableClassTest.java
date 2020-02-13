package homeworks.java.immutableClass;

import org.junit.Test;
import org.mutabilitydetector.unittesting.MutabilityAssert;

/**
 * MutabilityAssert is very convenient tool to test if class is actually immutable. It's not so clear
 * in this example but for large classes there will be great advantage.
 */
public class ImmutableClassTest {

    @Test
    public void testImmutability() {

        MutabilityAssert.assertImmutable(Immutable.class);

    }

    @Test(expected = org.mutabilitydetector.unittesting.MutabilityAssertionError.class)
    public void testMutability() {

        MutabilityAssert.assertImmutable(NotImmutable.class);

    }
}
