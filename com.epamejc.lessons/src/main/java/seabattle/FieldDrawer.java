package seabattle;

public abstract class FieldDrawer {

    public static void printFields(Field field1, Field field2) {
        System.out.print("\t");
        for (int i = 0; i < field1.getCellField()[0].length; i++) {
            System.out.print(" " + (char) (97 + i) + " ");
        }
        System.out.print("\t ");
        for (int i = 0; i < field2.getCellField()[0].length; i++) {
            System.out.print(" " + (char) (97 + i) + " ");
        }
        System.out.println();
        for (int i = 0; i < field1.getCellField().length; i++) { // 65-A, 97-a
            System.out.print(i + 1 + "\t");
            for (int j = 0; j < field1.getCellField()[i].length; j++) {
                System.out.print(" " + field1.getCellField()[i][j].getCellSymbol() + " ");
            }
            System.out.print("  " + (i + 1) + "\t");
            for (int j = 0; j < field2.getCellField()[i].length; j++) {
                System.out.print(" " + field2.getCellField()[i][j].getCellSymbol() + " ");
            }
            System.out.println();
        }
    }

    public static void printField(Field field) {
        System.out.print("\t");
        for (int i = 0; i < field.getCellField()[0].length; i++) {
            System.out.print(" " + (char) (97 + i) + " ");
        }
        System.out.println();
        for (int i = 0; i < field.getCellField().length; i++) { // 65-A, 97-a
            System.out.print(i + 1 + "\t");
            for (int j = 0; j < field.getCellField()[i].length; j++) {
                System.out.print(" " + field.getCellField()[i][j].getCellSymbol() + " ");
            }
            System.out.println();
        }
    }

}
