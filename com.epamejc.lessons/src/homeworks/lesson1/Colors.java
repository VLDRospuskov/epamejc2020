package homeworks.lesson1;

public enum Colors {

    GREEN (EscapeCodes.GREEN+ "Зеленый. Проходите!" + EscapeCodes.RESET),
    YELLOW (EscapeCodes.YELLOW + "Желтый. Завершайте движение." + EscapeCodes.RESET),
    RED (EscapeCodes.RED + "Красный. Стойте!" + EscapeCodes.RESET);

    private String message;

    Colors(String title) {
        this.message = title;
    }

    @Override
    public String toString() {
        return message;
    }
}
