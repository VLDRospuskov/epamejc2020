package homeworks.newSeabattle.data.enums;

public enum Messages {

    CHOOSE_PLAYERS ("Какой тип игры выбираете? " +
            "2 игрока (2), " +
            "игрок-компьютер (1), " +
            "или два компьютера (0)?"),
    NAME("Введите имя игрока : "),
    MANUAL_CREATION("Put ships manually (yes)? ");

    private String str;

    Messages(String str) {
        this.str = str;
    }

    @Override
    public String toString() { return str;}

}
