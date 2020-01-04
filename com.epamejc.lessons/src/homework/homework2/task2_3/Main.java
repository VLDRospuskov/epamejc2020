package homework.homework2.task2_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {
        try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Print number of levels:");
            int levels = getLevels(bufReader);
            System.out.println("Print order  \"ascending\" or \"descending\" :");
            String order = getOrder(bufReader);
            System.out.println("Print side \"left\" or \"right\" :");
            String side = getSide(bufReader);
            System.out.println("Print filling char  :");
            char symbol = getFillChar(bufReader);
            System.out.println("Your triangle :");
            new TrianglePrinter(symbol).printTriangle(levels, order, side);
        } catch (IOException e) {
            System.err.println("An unexpected I/O error has occurred.");
        }
    }

    private int getLevels(BufferedReader bufReader) throws IOException, IllegalArgumentException {
        if (bufReader == null) {
            throw new IllegalArgumentException("BufferedReader is null!");
        }
        while (true) {
            try {
                int levels = Integer.parseInt(bufReader.readLine());
                if (levels < 0) {
                    System.err.println("Non-negative integer required. Try again!");
                } else {
                    return levels;
                }
            } catch (NumberFormatException ex) {
                System.err.println("Non-negative integer required. Try again!");
            }
        }
    }

    private String getOrder(BufferedReader bufReader) throws IOException {
        if (bufReader == null) {
            throw new IllegalArgumentException("BufferedReader is null!");
        }
        while (true) {
            String order = bufReader.readLine();
            if (!order.equals("ascending") && !order.equals("descending")) {
                System.err.println("Available order \"ascending\" or \"descending\" . Try again!");
            } else {
                return order;
            }
        }
    }

    private String getSide(BufferedReader bufReader) throws IOException {
        if (bufReader == null) {
            throw new IllegalArgumentException("BufferedReader is null!");
        }
        while (true) {
            String side = bufReader.readLine();
            if (!side.equals("left") && !side.equals("right")) {
                System.err.println("Available side \"left\" or \"right\" . Try again!");
            } else {
                return side;
            }
        }
    }

    private char getFillChar(BufferedReader bufReader) throws IOException {
        if (bufReader == null) {
            throw new IllegalArgumentException("BufferedReader is null!");
        }
        while (true) {
            String line = bufReader.readLine();
            if (line.length() != 1) {
                System.err.println("1 symbol expected . Try again!");
            } else {
                return line.charAt(0);
            }
        }
    }
}
