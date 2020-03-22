package seabattle.gameField;


public class BattleField {

    public String[][] battleField;
    String emptyField = String.valueOf((char) 9633);


    public BattleField(String[][] battleField) {
        this.battleField = battleField;
        createBattlefield();
    }


    void createBattlefield() {
        // Заполняем цифры, буквы и девять игровых строк
        battleField[0] = new String[]{"  ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        for (int i = 1; i < 10; i++) {
            battleField[i][0] = " " + i;
            for (int j = 1; j < 11; j++) {
                battleField[i][j] = emptyField;
            }
        }
        battleField[10][0] = "10"; //заполняем 10ю строку (чтобы "10" была вровень с другими цифрами)
        for (int i = 1; i < 11; i++) {
            battleField[10][i] = emptyField;
        }
    }


    public void drawField(String description) {
        System.out.println(description);
        for (String[] line : battleField) {
            for (String field : line) {
                System.out.print(field);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
