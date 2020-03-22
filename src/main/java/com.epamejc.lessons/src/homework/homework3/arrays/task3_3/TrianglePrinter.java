package com.epamejc.lessons.src.homework.homework3.arrays.task3_3;

public class TrianglePrinter {
    private final char fillSymbol;

    TrianglePrinter(char fillSymbol) {
        this.fillSymbol = fillSymbol;
    }

    public void printTriangle(int levels, String order, String side) throws IllegalArgumentException {
        checkValues(levels, order, side);
        for (int i = 0; i <= levels; i++) {
            if (order.equals("ascending")) {
                if (side.equals("right")) {
                    for (int k = 0; k < levels; k++) {
                        System.out.print(" ");
                    }
                }
                for (int k = 0; k < i; k++) {
                    System.out.print(fillSymbol);
                }
            } else {
                if (side.equals("right")) {
                    for (int k = levels - i; k < levels; k++) {
                        System.out.print(" ");
                    }
                }
                for (int k = 0; k < levels - i; k++) {
                    System.out.print(fillSymbol);
                }
            }
            System.out.println();
        }
    }

    private void checkValues(int levels, String order, String side) throws IllegalArgumentException {
        if (levels < 0) {
            throw new IllegalArgumentException("Wrong value: levels. Non-negative value is required!");
        }
        if (!order.equals("ascending") && !order.equals("descending")) {
            throw new IllegalArgumentException("Wrong value: order. Use \"ascending\" or \"descending\"");
        }
        if (!side.equals("left") && !side.equals("right")) {
            throw new IllegalArgumentException("Wrong value: side. Use \"left\" or \"right\"");
        }
    }
}
