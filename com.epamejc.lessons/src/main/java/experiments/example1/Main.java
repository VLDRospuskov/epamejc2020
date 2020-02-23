package experiments.example1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        //можно обернуть в try\catch. блок catch обязателен. finally не обязателен.
        try {
            reader.readLine();
        } catch (IOException e) {
            System.err.println("Input Output error");
        }
    }

    public static void read() throws IOException {
        //можно обернуть в try\catch без блока catch, finally обязателен,
        // но тогда нужно пробросить исключение в сигнатуру метода
        try {
            reader.readLine();
        } finally {
            reader.close();
        }
    }

    public static void read2() throws IOException {
        //можно обернуть в try with resources блоки catch & finally не обязательны,
        // но нужно пробросить исключение в сигнатуру метода.
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            bf.readLine();
        }
    }

}
