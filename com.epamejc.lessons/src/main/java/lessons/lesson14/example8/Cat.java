package lessons.lesson14.example8;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Comparator;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cat implements Comparable<Cat> {
    
    private int id;
    
    @Override
    public int hashCode() {
        return id;
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
        return id == cat.id;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public int compareTo(Cat o) {
        Comparator<Cat> catComparator = Comparator.comparingInt(Cat::getId);
        return catComparator.compare(this, o);
    }
    
}
