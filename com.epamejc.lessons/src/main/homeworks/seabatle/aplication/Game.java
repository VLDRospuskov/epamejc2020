package homeworks.seabatle.aplication;

public class Game implements Runnable{
    @Override
    public void run() {
        StartingLogo logo = new StartingLogo();
        SeaBattle seaBattle = new SeaBattle();
        Thread startLogo = new Thread(logo);
        Thread gameThread = new Thread(seaBattle);
        try {
            startLogo.start();
            startLogo.join();
            gameThread.start();
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
