package main.lessons.lesson8.example3;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        getLine();
    }

    @SneakyThrows
    public static void getLine() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

        }
    }

}
