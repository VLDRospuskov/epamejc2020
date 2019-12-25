package homework.homework2;

import lombok.Value;
import java.util.HashMap;

// @Value lombok annotation
final class ImmutableClass {
    private final int id;
    private final String name;
    private final HashMap valueMap = new HashMap();

    ImmutableClass(int id, String name) {
        this.id = id;
        this.name = name;
        this.valueMap.put(id, name);
    }

    int getId() {
        return this.id;
    }

    String getName() {
        return this.name;
    }

    HashMap getValueMap() {
        return valueMap;
    }
}
