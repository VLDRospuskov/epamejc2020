package seabattle;

public abstract class FieldDrawer {

    public static void printFields(Field field1, Field field2) {
        printFirstLine(field1, "\t");
        printFirstLine(field2, "\t    ");
        System.out.println();
        for (int i = 0; i < field1.getCellField().length; i++) { // 65-A, 97-a
            printRow(field1, i);
            System.out.print(" ");
            printRow(field2, i);
            System.out.println();
        }
    }

    private static void printRow(Field field1, int i) {
        System.out.print(i + 1 + "\t");
        for (int j = 0; j < field1.getCellField()[i].length; j++) {
            System.out.print(" " + field1.getCellField()[i][j].getCellSymbol() + " ");
        }
    }

    private static void printFirstLine(Field field1, String s) {
        System.out.print(s);
        for (int i = 0; i < field1.getCellField()[0].length; i++) {
            System.out.print(" " + (char) (97 + i) + " ");
        }
    }

    public static void printField(Field field) {
        printFirstLine(field, "\t");
        System.out.println();
        for (int i = 0; i < field.getCellField().length; i++) { // 65-A, 97-a
            printRow(field, i);
            System.out.println();
        }
    }

}
