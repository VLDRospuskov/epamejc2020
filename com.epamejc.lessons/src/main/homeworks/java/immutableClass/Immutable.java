package homeworks.java.immutableClass;

import lombok.*;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Getter
public final class Immutable {
    private final double constant;
    private final String constantName;
}
