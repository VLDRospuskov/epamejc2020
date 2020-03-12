package lessons.lesson19.example2;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Main {
    
    public static void main(String[] args) {
        final Animal barsik = new Animal(1, "Barsik");
        final Animal rijik = new Animal(2, "Rijik");
        final Animal murzik = new Animal(3, "Murzik");
        
        new MyThread(barsik).start();
        new MyThread(rijik).start();
        new MyThread(murzik).start();
    }
    
}

class MyThread extends Thread {
    
    private final Animal animal;
    
    public MyThread(Animal animal) {
        this.animal = animal;
    }
    
    public void run() {
        animal.printInfo();
    }
    
}

@Data
@AllArgsConstructor
class Animal {
    
    private int id;
    private String name;
    
    public synchronized void printInfo() {
        System.out.println(Thread.currentThread());
        System.out.println(this.id);
        System.out.println(this.name);
    }
    
}
