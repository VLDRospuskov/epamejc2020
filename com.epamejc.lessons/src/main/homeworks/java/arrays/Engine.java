package homeworks.java.arrays;

public class Engine {

    public void run() {

        UserMenu userMenu = new UserMenu();
        RandomCharArray array = new RandomCharArray();
        System.out.println("Welcome to an Array test program!\n");

        boolean isDone;
        do {
            System.out.println(userMenu);
            isDone = userMenu.switchMenu(array);
        } while (!isDone);
        System.out.println("Bye-bye!");

    }

}