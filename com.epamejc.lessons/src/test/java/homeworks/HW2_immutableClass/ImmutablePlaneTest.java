package homeworks.HW2_immutableClass;

import org.junit.Test;
import org.mutabilitydetector.unittesting.MutabilityAssert;

public class ImmutablePlaneTest {

    /**
     * Testing immutability of ImmutablePlane class
     */
    @Test
    public void immutabilityTest() {
        MutabilityAssert.assertImmutable(ImmutablePlane.class);
    }
}