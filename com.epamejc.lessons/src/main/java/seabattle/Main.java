package seabattle;

import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
    void parsCommand(){}//todo Сделать метод который будет парсть команды
}

class Pole {
    private List<List<Cell>> Ships;


}

enum ships {
    SHIP1,
    SHIP2,
    SHIP3,
    SHIP4
}

enum state {
    SHIP,
    HIT,
    CLEAR
}

class Cell {
    private ships typeOfShip;
    private state state;

}

class user{
    private List<String> ships;//todo Сделать такую структуру, что бы можно было хранить количество и тип кораблей для поатвновки на доску

}
