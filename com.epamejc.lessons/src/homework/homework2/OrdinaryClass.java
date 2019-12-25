package homework.homework2;

import lombok.Data;
import java.util.HashMap;


@Data // lombok annotation
class OrdinaryClass {
    private int id;
    private String name;
    private HashMap valueMap = new HashMap();
}
