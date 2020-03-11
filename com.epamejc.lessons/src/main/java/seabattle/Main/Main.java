package seabattle.Main;

public class Main {

    public static void main(String[] args) {
        GameLauncher gameLauncher = new GameLauncher();
        gameLauncher.launchGame();
    }

    public static void da(B b) {
        System.out.println("daB");
    }

}

class A {

}
class B extends A {
    public void kil() {
        System.out.println("HELLO I AM B");
    }
}
