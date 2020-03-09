package homeworks.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    public void run(){

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {

                System.out.print("Enter time or 'exit': ");
                String userInput = reader.readLine();

                if (userInput != null && userInput.equalsIgnoreCase("exit")) {
                    System.out.println("Ending program!");
                    break;
                }

                InputHandler handler = new InputHandler();
                handler.handleUserInput(userInput);
            }
        } catch (IOException ex) {
            System.out.println("Got a IOException");
        }
    }
}
