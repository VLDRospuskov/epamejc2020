package homeworks.newSeabattle.data.enums;

public enum Messages {

    GAME_CHOOSING ("Какой тип игры выбираете? " +
            "2 игрока (2), " +
            "игрок-компьютер (1), " +
            "или два компьютера (0)?"),
    GETTING_NAME("Введите имя игрока : ");

    private String str;

    Messages(String str) {
        this.str = str;
    }

    @Override
    public String toString() { return str;}

}
