package seaBattle.logic;

/**
 * @version 0.1
 * @author Andrew Nuzha
 */
public class Application {

    private int fieldSize = 10;

    public Application(){
        //прочитать конфиг?
    }

    public void run() {
        System.out.println("Welcome to seabattle game ver 0.1\n");
        // 1. сгенерили поля
        FieldOperator fieldOperator = new FieldOperator(fieldSize);
        fieldOperator.generateFields();

        // 2. сгенерили список кораблей
        ShipOperator shipOperator = new ShipOperator(1, 2 , 3, 4);
        shipOperator.generateShips();
        shipOperator.placeShipsAutomatically(fieldOperator);

        FieldPrinter fieldPrinter = new FieldPrinter(fieldSize);
        //fieldPrinter.printField(playerField,botField);
        //setShips(playerShips);
    }
}
