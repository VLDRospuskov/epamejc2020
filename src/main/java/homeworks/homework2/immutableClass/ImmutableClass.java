package homeworks.homework2.immutableClass;

import java.util.HashMap;
import java.util.Map;


public final class ImmutableClass {
    private final int id;
    private final String name;
    private final Map<Integer, String> valueMap = new HashMap<>();

    public ImmutableClass(int id, String name) {
        this.id = id;
        this.name = name;
        this.valueMap.put(id, name);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Map<Integer, String> getValueMap() {
        return valueMap;
    }
}
