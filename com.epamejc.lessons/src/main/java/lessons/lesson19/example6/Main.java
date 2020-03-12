package lessons.lesson19.example6;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        final Cat cat = new Cat();
        final CatThread catThread = new CatThread(cat);
        catThread.start();
        
        TimeUnit.SECONDS.sleep(2);
        cat.setName("BARSIK");
        synchronized (Resource.lock) {
            Resource.lock.notify();
//            cat.notify();
        }
    }
    
}

class Resource {
    
    static Object lock = new Object();
    
}

class CatThread extends Thread {
    
    private final Cat cat;
    
    public CatThread(Cat cat) {
        this.cat = cat;
    }
    
    @Override
    @SneakyThrows
    public void run() {
        System.out.println("THREAD CAT STARTED");
        synchronized (Resource.lock) {
            Resource.lock.wait();
//            cat.wait();
        }
        System.out.println(cat.getName());
        System.out.println("THREAD CAT ENDED!");
    }
    
}

@Data
@NoArgsConstructor
class Cat {
    
    private String name;
    
}