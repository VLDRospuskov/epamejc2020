package homeworks.java.strings;

import homeworks.java.utils.UserInputReader;

public class Engine {

    public void run() {

        UserMenu userMenu = new UserMenu();
        StringChanger stringChanger = new StringChanger();
        System.out.println("Welcome to a String changer test program!\n" +
                "Please enter text here:");
        stringChanger.setStoredString(UserInputReader.readInput());
        boolean isDone;
        do {
            System.out.println(userMenu);
            isDone = userMenu.switchMenu(stringChanger);
        } while (!isDone);
        System.out.println("Bye-bye!");

    }

}