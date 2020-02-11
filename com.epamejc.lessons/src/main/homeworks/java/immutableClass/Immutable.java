package homeworks.java.immutableClass;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Getter
public final class Immutable {
    private final double constant;
    private final String constantName;
}
