package main.homeworks.homework1;

import java.io.*;

public class Main {

           public static void main(String[] args) {

            boolean isDone;
            TrafficLights app = new TrafficLights();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

                do {
                    isDone=app.run(reader);
                } while (!isDone);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
   }
