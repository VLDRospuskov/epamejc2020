package homeworks.java.immutableClass;


import lombok.SneakyThrows;
import org.junit.Test;
import org.mutabilitydetector.unittesting.MutabilityAssert;

import java.lang.reflect.Field;

public class ImmutableClassTest {

    @Test
    public void immutabilityTest() {
        MutabilityAssert.assertImmutable(Immutable.class);
    }

    @Test (expected = org.mutabilitydetector.unittesting.MutabilityAssertionError.class)
    public void notImmutabilityTest() {
        MutabilityAssert.assertImmutable(NotImmutable.class);
    }
}
