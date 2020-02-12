package homework.homework2.immutableClass;

import lombok.Data;
import java.util.HashMap;


@Data
public class OrdinaryClass {
    private int id;
    private String name;
    private HashMap valueMap = new HashMap();

    public void setValueMap(int id, String name) {
        this.valueMap.put(id,name);
    }
}
