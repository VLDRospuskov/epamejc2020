package lessons.lesson12.example13;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cat {
    
    private static final long serialVersionUID = 1568764800L;
    
    private int id;
    private String name;
//    private int age;

}
