package lessons.lesson12.example13;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class ExtendedCat extends Cat implements Serializable {

    private String type;
//    private String height;



    public ExtendedCat(int id, String name, String type) {
        super(id, name);
        this.type = type;
    }
}
