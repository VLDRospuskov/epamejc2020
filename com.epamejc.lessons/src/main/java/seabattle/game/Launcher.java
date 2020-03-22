package seabattle.game;

import java.io.IOException;

/**
 * The game is not finished.
 * What is done:
 * - The playing field is created.
 * - The user arranges the ships.
 * - The computer arranges the ships.
 * - Check that the ships do not go out of the field.
 * - Information on the status of each cell is recorded.
 * Not done:
 * - Players do not shoot.
 * - There is no check for the incorrect arrangement of ships.
 * - There is no check for incorrect data input from the keyboard.
 *---------------------------------------------------------------------
 * Игра не дописана.
 * Что сделано:
 * - Сделано игровое поле.
 * - Пользователь расставляет корабли.
 * - Компьютер расставляет корабли.
 * - Проверка на то, чтобы корабли не выходили за пределы поля.
 * - Записывается информация о статусе каждой клетки.
 * Не сделано:
 * - Игроки не стреляют.
 * - Нет проверки на неправильную расстановку кораблей.
 * - Нет проверки на неправильный ввод данных с клавиатуры.
 */

public class Launcher {

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.startGame();
    }
}
