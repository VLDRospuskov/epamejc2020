package homework.homework2.task2_3;

public class TrianglePrinter {
    private char fillSymbol;

    TrianglePrinter(char fillSymbol) {
        this.fillSymbol = fillSymbol;
    }

    public void printTriangle(int levels, String order, String side) {
        if (levels < 0) {
            throw new IllegalArgumentException("Wrong value: levels. Non-negative value is required!");
        }
        if (!order.equals("ascending") && !order.equals("descending")) {
            throw new IllegalArgumentException("Wrong value: order. Use \"ascending\" or \"descending\"");
        }
        if (!side.equals("left") && !side.equals("right")) {
            throw new IllegalArgumentException("Wrong value: side. Use \"left\" or \"right\"");
        }
        for (int i = 0; i <= levels; i++) {
            if (side.equals("right")) {
                for (int k = 0; k < levels; k++) {
                    System.out.print(" ");
                }
            }
            if (order.equals("ascending")) {
                for (int k = 0; k < i; k++) {
                    System.out.print(fillSymbol);
                }
            } else {
                for (int k = 0; k < levels - i; k++) {
                    System.out.print(fillSymbol);
                }
            }
            System.out.println();
        }
    }
}
