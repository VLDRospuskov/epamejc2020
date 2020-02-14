package homeworks.java.arrays;

/**
 * The {@code Engine class} represents the main loop of the program.
 *
 * @author Vladimir Ivanov
 */
public class Engine {

    /**
     * Runs the program.
     */
    public void run() {

        UserMenu userMenu = new UserMenu();
        RandomCharArray array = new RandomCharArray();
        System.out.println("Welcome to an Array test program!\n");

        boolean isDone;
        do {
            userMenu.printMenu();
            isDone = userMenu.switchMenu(array);
        } while (!isDone);

        System.out.println("Bye-bye!");

    }

}

