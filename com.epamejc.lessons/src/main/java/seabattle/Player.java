package seabattle;

import homeworks.InputReader;

import java.util.Iterator;

public class Player {
    
    Field myField;
    Field opponentsField;
    View view;
    Field opponentsFieldData;
    
    public Player() {
        this.setMyField(new Field());
        this.setView(new View());
        this.setOpponentsField(new Field());
    }
    
    static void skip40rows() {
        for (int i = 0; i < 40; i++) {
            System.out.println('.');
        }
    }
    
    public Field getOpponentsFieldData() {
        return opponentsFieldData;
    }
    
    public void setOpponentsFieldData(Field field) {
        this.opponentsFieldData = field;
    }
    
    public Field getOpponentsField() {
        return opponentsField;
    }
    
    public View getView() {
        return view;
    }
    
    public Field getMyField() {
        return myField;
    }
    
    public void fieldFillStrategy() {
        System.out.println("Input \'1\' for manual ship placement or Any other key for random generation");
        if ("1".equals(InputReader.nextString()
                                  .toLowerCase())) {
            fillListOfShipsManually();
        } else {
            fillListOfShipsRandomly();
        }
    }
    
    public void turn(String s) {
        skip40rows();
        System.out.println(s + " Input any symbol to continue");
        InputReader.nextString();
        shotMethod();
    }
    
    public void shotMethod() {
        System.out.println("My field");
        view.printField(myField);
        System.out.println("Opponents field");
        view.printField(opponentsField);
        shotWhileHit();
    }
    
    public void fillListOfShipsRandomly() {
        while (myField.ships
                       .size() != 10) {
            myField.fillListOfShipsDependingOnLength(4, 1);
            if (myField.getCountByLength(4) == 1) {
                myField.fillListOfShipsDependingOnLength(3, 2);
            }
            if (myField.getCountByLength(4) == 1 && myField.getCountByLength(3) == 2) {
                myField.fillListOfShipsDependingOnLength(2, 3);
            }
            if (myField.getCountByLength(4) == 1 && myField.getCountByLength(3) == 2 && myField.getCountByLength(2) ==
                                                                                        3) {
                myField.fillListOfShipsDependingOnLength(1, 4);
            }
        }
        System.out.println("My Field");
        view.updateFieldView(myField);
        view.printField(myField);
    }
    
    public int takeAShot(Field field, Coordinate shotCoordinate) {
        Iterator shipIterator = field.getShips().iterator();
        int result;
        while (shipIterator.hasNext()) {
            Ship ship = (Ship) shipIterator.next();
            Iterator shipPartsIterator = ship.getShipParts()
                                             .iterator();
            result = iterateShipParts(shotCoordinate, shipIterator, ship, shipPartsIterator);
            if (result > 0) {
                return result;
            }
        }
        opponentsField.getMisses()
                      .add(new Miss(shotCoordinate));
        opponentsFieldData.getMisses()
                          .add(new Miss(shotCoordinate));
        System.out.println("Miss");
        return 0;
    }
    
    private int iterateShipParts(
            Coordinate shotCoordinate, Iterator shipIterator, Ship ship, Iterator shipPartsIterator) {
        while (shipPartsIterator.hasNext()) {
            Coordinate shipCoordinate = (Coordinate) shipPartsIterator.next();
            if (shotCoordinate.equals(shipCoordinate)) {
                return hitOrKill(shotCoordinate, shipIterator, ship, shipPartsIterator, shipCoordinate);
            }
        }
        return 0;
    }
    
    private int hitOrKill(
            Coordinate shotCoordinate, Iterator shipIterator, Ship ship, Iterator shipPartsIterator,
            Coordinate shipCoordinate) {
        if (ship.getShipParts().size() > 1) {
            hit(shotCoordinate, shipPartsIterator);
            return 1;
        } else {
            kill(shotCoordinate, shipIterator, ship, shipPartsIterator, shipCoordinate);
            return 2;
        }
    }
    
    private void shotWhileHit() {
        int fireResult = -1;
        Coordinate shotCoordinate;
        while (fireResult != 0 && opponentsFieldData.ships
                                          .size() > 0 && myField.ships
                                                                 .size() > 0) {
            shotCoordinate = inputWhileNotCorrectCoordinate();
            opponentsField.shots.add(new Shot(shotCoordinate));
            fireResult = takeAShot(opponentsFieldData, shotCoordinate);
            System.out.println("My Field");
            view.printField(myField);
            System.out.println("My view of opponents field");
            view.printField(opponentsField);
        }
    }
    
    private Coordinate inputWhileNotCorrectCoordinate() {
        Coordinate shotCoordinate;
        do {
            System.out.println("Input correct shot coordinate and don't shoot twice at same point");
            shotCoordinate = new Coordinate().input();
        } while (!Coordinate.isCoordinatesCorrect(shotCoordinate) || opponentsField.checkShotsCollision(
                shotCoordinate));
        return shotCoordinate;
    }
    
    private void kill(
            Coordinate shotCoordinate, Iterator shipIterator, Ship ship, Iterator shipPartsIterator,
            Coordinate shipCoordinate) {
        System.out.println("kill");
        shipPartsIterator.remove();
        opponentsField.addAssistPointsAroundKill(shotCoordinate, ship);
        shipIterator.remove();
        opponentsFieldData.shots
                .add(new Shot(shipCoordinate));
    }
    
    private void hit(Coordinate shotCoordinate, Iterator shipPartsIterator) {
        shipPartsIterator.remove();
        System.out.println("hit");
        opponentsField.addAssistPointsAroundShot(shotCoordinate);
        opponentsFieldData.shots.add(new Shot(shotCoordinate));
    }
    
    private void setOpponentsField(Field opponentsField) {
        this.opponentsField = opponentsField;
    }
    
    private void setView(View view) {
        this.view = view;
    }
    
    private void setMyField(Field myField) {
        this.myField = myField;
    }
    
    private void fillListOfShipsManually() {
        view.printField(myField);
        inputShip();
        System.out.println("My Field");
        view.printField(myField);
    }
    
    private void inputShip() {
        Coordinate first;
        Coordinate second;
        while (myField.shots
                       .size() != 10) {
            myField.printState();
            first = new Coordinate().input();
            second = new Coordinate().input();
            if (Coordinate.isCoordinatesCorrect(first, second)) {
                Ship ship = new Ship(first, second);
                addCorrectShip(ship);
            } else {
                System.out.println(myField.ships);
                System.out.println("Wrong coordinates");
            }
        }
    }
    
    private void addCorrectShip(Ship ship) {
        if (myField.checkNoShipCollision(ship) && myField.checkCorrectAmountOfShips(ship)) {
            myField.ships
                    .add(ship);
            myField.addAssistPointsAroundShip(ship);
            System.out.println("My Field");
            view.printField(myField);
            
        } else {
            System.out.println("You need to place 4 ships of length 1, 3 ships of length 2, 2 ships of length" +
                               " 3, 1 ship of length 4 in empty squares");
        }
    }
    
}
