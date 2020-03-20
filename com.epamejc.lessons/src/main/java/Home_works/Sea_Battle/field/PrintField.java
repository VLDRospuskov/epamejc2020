package Home_works.Sea_Battle.field;

public class PrintField {
    public static void printField(String[][] battlefield, String[][] moveChronologyField) {
        System.out.println("       Your Field            Enemy Field");
        printNumeralScale();
        int alphabeticIndex = 65;
        for (int i = 0; i < battlefield.length; i++) {
            System.out.println(" ");
            System.out.print((char) alphabeticIndex + " ");
            for (int j = 0; j < battlefield[i].length; j++) {
                System.out.print(battlefield[i][j] + " ");
            }
            System.out.print("  ");
            System.out.print((char) alphabeticIndex++ + " ");
            for (int j = 0; j < moveChronologyField[i].length; j++) {
                System.out.print(moveChronologyField[i][j] + " ");
            }
        }
    }

    static void printNumeralScale() {
        System.out.print("  ");
        for (int j = 0; j < 2; j++) {
            for (int i = 1; i <= 10; i++) {
                System.out.print(i + " ");
            }
            System.out.print("   ");
        }
    }
}
