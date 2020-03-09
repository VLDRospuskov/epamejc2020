package homeworks.homework2.immutableClass;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;


@Data
public class OrdinaryClass {
    private int id;
    private String name;
    private Map<Integer, String> valueMap = new HashMap<>();

    public void setValueMap(int id, String name) {
        this.valueMap.put(id, name);
    }
}
