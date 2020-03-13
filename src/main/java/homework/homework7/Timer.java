package homework.homework7;

public class Timer {
    private long lastDuration = 0;
    private long startTime = 0;

    public long getLastDuration(){
        return lastDuration;
    }

    public void start(){
        startTime = System.currentTimeMillis();
    }

    public void stop(){
        if (startTime > 0) {
            long endTime = System.currentTimeMillis();
            lastDuration = endTime - startTime;
            startTime = 0;
        }
    }
}
