package Home_works.Sea_Battle.field;

public class FieldCreator {

    String ship = "0";
    String dot = ".";



    private String[][] field;

    public FieldCreator(int numeral, int alphabetic) {
        this.field = new String[numeral][alphabetic];
        this.field = getFillingField(this.field);
    }

    public String[][] getField() {
        return field;
    }

    public boolean checkFieldWinner() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals(ship)) {
                    return false;
                }
            }
        }
        return true;
    }

    private String[][] getFillingField(String[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = dot;
            }
        }
        return field;
    }

    public String changeCell(int numeral, int alphabetic, String symbol) {
        return this.field[numeral][alphabetic] = symbol;
    }

    public String getCell(int numeral, int alphabetic) {
        if (numeral < 10 & alphabetic < 10) {
            return this.field[numeral][alphabetic];
        }
        return "zero";
    }
}