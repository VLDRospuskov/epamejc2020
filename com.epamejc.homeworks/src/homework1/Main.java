package homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight=new TrafficLight();
        String newLine = "";
        int value;
        System.out.println("Print integer value between 0 and 10 to change color of traffic light or 'exit' to close the program");
        try(BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in))){
            while(true){
                try{
                    newLine = bufReader.readLine();
                    value = Integer.parseInt(newLine);
                    trafficLight.setColor(value);
                    System.out.println("Traffic Light : "+trafficLight.getColor());
                } catch ( IllegalArgumentException e) {
                    if (newLine.equals("exit")){
                        System.out.println("Bye-bye!");
                        System.exit(0);
                    }else{
                        System.out.println("Wrong Input! An integer value between 0 and 10 is required!");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An unexpected I/O error has occurred.");
            System.exit(1);
        }
    }
}
