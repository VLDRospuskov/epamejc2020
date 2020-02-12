package homework.homework2.immutableClass;

import java.util.HashMap;


public final class ImmutableClass {
    private final int id;
    private final String name;
    private final HashMap valueMap = new HashMap();

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

    public HashMap getValueMap() {
        return valueMap;
    }
}
