package homework.homework2.immutableClass;

import lombok.Data;
import java.util.HashMap;


@Data // lombok annotation
class OrdinaryClass {
    private int id;
    private String name;
    private HashMap valueMap = new HashMap();

    void setValueMap(int id, String name) {
        this.valueMap.put(id,name);
    }
}
