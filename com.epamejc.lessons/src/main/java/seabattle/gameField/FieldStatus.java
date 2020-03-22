package seabattle.gameField;

/**
 * List of playing field cell statuses.
 * Список статусов клетки игрового поля.
 */
public enum FieldStatus {
    CLEAR,                // чистое поле
    DECK,                 // палуба
    CANT_PUT_DECK,        // нельзя поставить палубу
    WOUNDED_DECK,         // убитая палуба
    SHOT_PAST             // выстрел мимо
}