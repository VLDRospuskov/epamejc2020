package lessons.lesson9.solid.interface_seg;

import lombok.ToString;

@ToString
public class Animal {
    
    private String name;
    private String sound;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSound() {
        return sound;
    }
    
}

