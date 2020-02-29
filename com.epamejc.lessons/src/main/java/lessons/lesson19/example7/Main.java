package lessons.lesson19.example7;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final Cat cat = new Cat();
        final CatThread catThread = new CatThread(cat);
        final CatThreadNotifySetName catThreadNotify = new CatThreadNotifySetName(cat);
        final CatThreadNotifySetAge catThreadNotifySetAge = new CatThreadNotifySetAge(cat);
        catThread.start();
        catThreadNotify.start();
        catThreadNotifySetAge.start();

        try {
            catThread.join();
            catThreadNotify.join();
            catThreadNotifySetAge.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class CatThreadNotifySetName extends Thread {

    private final Cat cat;

    public CatThreadNotifySetName(Cat cat) {
        this.cat = cat;
    }

    @Override
    @SneakyThrows
    public void run() {
        cat.setName("BARSIK");
        synchronized (cat) {
            System.out.println("NOTIFY THREAD NAME");
            cat.notifyAll();
        }
    }
}

class CatThreadNotifySetAge extends Thread {

    private final Cat cat;

    public CatThreadNotifySetAge(Cat cat) {
        this.cat = cat;
    }

    @Override
    @SneakyThrows
    public void run() {
        System.out.println("NOTIFY THREAD AGE");
        cat.setAge(10);
        synchronized (cat) {
            cat.wait();
        }
        System.out.println("THREAD CAT AGE ENDED!");
    }
}

class CatThread extends Thread {

    private final Cat cat;

    public CatThread(Cat cat) {
        this.cat = cat;
    }

    @Override
    @SneakyThrows
    public void run() {
        System.out.println("THREAD CAT INFO");
        synchronized (cat) {
            cat.wait();
        }
        System.out.println(cat.getName());
        System.out.println(cat.getAge());
        System.out.println("THREAD CAT ENDED!");
    }
}

@Data
@NoArgsConstructor
class Cat {

    private String name;
    private int age;

}