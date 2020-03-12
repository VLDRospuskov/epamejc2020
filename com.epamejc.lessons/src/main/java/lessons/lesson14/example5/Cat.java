package lessons.lesson14.example5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cat {
    
    private int id;
    private int age;
    
    @Override
    public int hashCode() {
        return 31 * id * age;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cat cat = (Cat) o;
        return id == cat.id &&
               age == cat.age;
    }
    
}
