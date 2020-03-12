package lessons.lesson20.example1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    
    public static void main(String[] args) {
        final RemoveThread removeThread = new RemoveThread();
        final AddThread addThread = new AddThread();
        
        removeThread.setPriority(10);
        removeThread.start();
        addThread.start();
        
        System.out.println(Resource.strings);
    }
    
}

class Resource {
    
    public static ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<>(10);
    public static List<String> stringList = new ArrayList<>();
    
}

class AddThread extends Thread {
    
    @Override
    public void run() {
        Resource.strings.add("Hello");
        System.out.println(Resource.strings);
    }
    
}

class RemoveThread extends Thread {
    
    @Override
    public void run() {
        Resource.strings.remove(0);
    }
    
}