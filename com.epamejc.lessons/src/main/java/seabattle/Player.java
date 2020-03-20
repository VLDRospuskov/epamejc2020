package seabattle;

import homeworks.InputReader;

import java.util.Iterator;

public class Player {
    
    Field myField;
    Field opponentsFieldData;
    Field opponentsField;
    View view;
    boolean fireState;
    
    public Player() {
        this.myField = new Field();
        this.view = new View();
        this.opponentsField = new Field();
        fireState = false;
        //this.shots = new ArrayList();
    }
    
    public Field getMyField() {
        return myField;
    }
    
    public void setMyField(Field myField) {
        this.myField = myField;
    }
    
    public void setOpponentsFieldData(Field field) {
        this.opponentsFieldData = field;
    }
    
    public void selectFieldFillStrategy() {
        System.out.println("Input \'1\' for manual ship placement or Any other key for random generation");
        if ("1".equals(InputReader.nextString()
                                  .toLowerCase())) {
            fillListOfShipsManually();
        } else {
            fillListOfShipsRandomly();
        }
    }
    
    public void fillListOfShipsManually() {
        
        Coordinate first;
        Coordinate second;
        view.printField(myField);
        while (myField.getShips()
                      .size() != 10) {
            myField.printState();
            first = new Coordinate().input();
            second = new Coordinate().input();
            if (Coordinate.checkCoordinates(first, second)) {
                Ship ship = new Ship(first, second);
                if (myField.checkNoShipCollision(ship) && myField.checkCorrectAmountOfShips(ship)) {
                    myField.ships.add(ship);
                    myField.addPointsAroundShip(ship);
                    //view.updateFieldView(myField);
                    System.out.println("My Field");
                    view.printField(myField);
                    
                } else {
                    System.out.println("You need to place 4 ships of length 1, 3 ships of length 2, 2 ships of length" +
                                       " 3, 1 ship of length 4 in empty squares");
                }
            } else {
                System.out.println(myField.getShips());
                System.out.println("Wrong coordinates");
            }
        }
        System.out.println("My Field");
        view.printField(myField);
    }
    
    public void fillListOfShipsRandomly() {
        int state = 0;
        while (myField.getShips()
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
    
    public void shotMethod() {
        int fireResult = -1;
        Coordinate shotCoordinate;
        System.out.println("My field");
        view.printField(myField);
        System.out.println("Opponents field");
        view.printField(opponentsField);
        while (fireResult != 0 && opponentsFieldData.getShips()
                                                    .size() > 0 && myField.getShips()
                                                                          .size() > 0) {
            do {
                System.out.println("Input correct shot coordinate and don't shoot twice at same point");
                shotCoordinate = new Coordinate().input();
            } while (!Coordinate.checkCoordinates(shotCoordinate) || opponentsField.checkShotsCollision(
                    shotCoordinate));
            opponentsField.getShots()
                          .add(new Shot(shotCoordinate));
            fireResult = takeAShot(opponentsFieldData, shotCoordinate);
            System.out.println("My Field");
            view.printField(myField);
            System.out.println("My view of opponents field");
            view.printField(opponentsField);
            //System.out.println("Opponents field");
            //view.printField(opponentsFieldData);
        }
    }
    
    public int takeAShot(Field field, Coordinate shotCoordinate) {
        Iterator shipIterator = field.getShips()
                                     .iterator();
        while (shipIterator.hasNext()) {
            Ship ship = (Ship) shipIterator.next();
            Iterator shipPartsIterator = ship.getShipParts()
                                             .iterator();
            while (shipPartsIterator.hasNext()) {
                Coordinate shipCoordinate = (Coordinate) shipPartsIterator.next();
                if (shotCoordinate.equals(shipCoordinate)) {
                    if (ship.getShipParts()
                            .size() > 1) {
                        shipPartsIterator.remove();
                        System.out.println("hit");
                        opponentsField.addPointsAroundShot(shotCoordinate);
                        opponentsFieldData.shots.add(new Shot(shotCoordinate));
                        return 1;
                    } else {
                        System.out.println("kill");
                        shipPartsIterator.remove();
                        opponentsField.addPointsAroundKill(shotCoordinate, ship);
                        shipIterator.remove();
                        opponentsFieldData.getShots()
                                          .add(new Shot(shipCoordinate));
                        return 2;
                    }
                }
            }
        }
        opponentsField.getMisses()
                      .add(new Miss(shotCoordinate));
        opponentsFieldData.getMisses()
                          .add(new Miss(shotCoordinate));
        System.out.println("Miss");
        return 0;
    }
    
}
