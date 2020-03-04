package homework.homework4;

import lombok.Data;

public class Timer {
    private long lastDuration = 0;
    long startTime = 0;

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
