package lessons.lesson7.example2;

import java.util.Objects;

public class Message <T1, T2> {
    
    private T1 id;
    private T2 name;
    
    public Message(T1 id, T2 name) {
        this.id = id;
        this.name = name;
    }
    
    public T1 getId() {
        return id;
    }
    
    public void setId(T1 id) {
        this.id = id;
    }
    
    public T2 getName() {
        return name;
    }
    
    public void setName(T2 name) {
        this.name = name;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Message<?, ?> message = (Message<?, ?>) o;
        return Objects.equals(id, message.id) &&
               Objects.equals(name, message.name);
    }
    
    @Override
    public String toString() {
        return "Message{" +
               "id=" + id +
               ", name=" + name +
               '}';
    }
    
}
