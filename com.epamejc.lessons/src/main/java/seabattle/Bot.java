package seabattle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Bot extends Player {
    
    List<Coordinate> possibleVariants = new ArrayList<>();
    Shot previousHit;
    
    public Bot() {
    }
    
    @Override public void fieldFillStrategy() {
        super.fillListOfShipsRandomly();
    }
    
    public void turn(String s) {
        skip40rows();
//        System.out.println(s + " Input any symbol to continue");
//        InputReader.nextString();
        shotMethod();
    }
    
    @Override public void shotMethod() {
        int fireResult = -1;
        Coordinate shotCoordinate;
        System.out.println("My field");
        view.printField(myField);
        System.out.println("Opponents field");
        view.printField(opponentsField);
        while (fireResult != 0 && opponentsFieldData.getShips()
                                                    .size() > 0 && myField.getShips()
                                                                          .size() > 0) {
//            do {
            if (possibleVariants.size() == 0) {
                do {
                    //shotCoordinate = new Coordinate(4,4);
                    shotCoordinate = Coordinate.generateRandomCoordinate();
                } while (!Coordinate.isCoordinatesCorrect(shotCoordinate) || opponentsField.checkShotsCollision(
                        shotCoordinate));
            } else {
                shotCoordinate = possibleVariants.get(new Random().nextInt(possibleVariants.size()));
            }
            //System.out.println("Input correct shot coordinate and don't shoot twice at same point");

//            } while (!Coordinate.isCoordinatesCorrect(shotCoordinate) || opponentsField.checkShotsCollision(
//                    shotCoordinate));
            
            Shot shot = new Shot(shotCoordinate);
            opponentsField.getShots()
                          .add(shot);
            possibleVariants.remove(shotCoordinate);
            fireResult = takeAShot(opponentsFieldData, shotCoordinate);
            if (fireResult > 0) {
                addPossibleVariantsOfShots(shotCoordinate);
                previousHit = shot;
            }
            System.out.println("My Field");
            view.printField(myField);
            System.out.println("My view of opponents field");
            view.printField(opponentsField);
            //System.out.println("Opponents field");
            //view.printField(opponentsFieldData);
        }
    }
    
    @Override public int takeAShot(Field field, Coordinate shotCoordinate) {
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
                        opponentsField.addAssisstPointsAroundShot(shotCoordinate);
                        Shot shot = new Shot(shotCoordinate);
                        opponentsFieldData.shots.add(shot);
                        if (possibleVariants.size() > 1 && isNearPrevious(shot)) {
                            Ship hypotheticalShip = new Ship(shotCoordinate, previousHit.coordinate);
                            
                            switch (hypotheticalShip.getDirection()) {
                                case 1:
                                    removePossibleVerticalPoints();
                                    break;
                                case 2:
                                    removePossibleHorizontalPoints();
                                    break;
                            }
                        }
                        return 1;
                    } else {
                        System.out.println("kill");
                        shipPartsIterator.remove();
                        opponentsField.addAssistPointsAroundKill(shotCoordinate, ship);
                        shipIterator.remove();
                        opponentsFieldData.getShots()
                                          .add(new Shot(shipCoordinate));
                        possibleVariants = new ArrayList<>();
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
    
    public List<Coordinate> getPossibleVariants() {
        return possibleVariants;
    }
    
    public void setPossibleVariants(List<Coordinate> possibleVariants) {
        this.possibleVariants = possibleVariants;
    }
    
    private void removePossibleVerticalPoints() {
        Iterator possibleVariantsIterator = getPossibleVariants().iterator();
        while (possibleVariantsIterator.hasNext()) {
            Coordinate coordinate = (Coordinate) possibleVariantsIterator.next();
            if (coordinate.getY() > previousHit.coordinate.getY() ||
                coordinate.getY() < previousHit.coordinate.getY()) {
                possibleVariantsIterator.remove();
            }
        }
    }
    
    private void removePossibleHorizontalPoints() {
        Iterator possibleVariantsIterator = getPossibleVariants().iterator();
        while (possibleVariantsIterator.hasNext()) {
            Coordinate coordinate = (Coordinate) possibleVariantsIterator.next();
            if (coordinate.getX() > previousHit.coordinate.getX() ||
                coordinate.getX() < previousHit.coordinate.getX()) {
                possibleVariantsIterator.remove();
            }
        }
    }
    
    private boolean isNearPrevious(Shot shot) {
        return (Math.abs(previousHit.coordinate.getX() - shot.coordinate.getX()) < 2 && Math.abs(
                previousHit.coordinate.getY() - shot.coordinate.getY()) < 2);
    }
    
    private void addPossibleVariantsOfShots(Coordinate shotCoordinate) {
        Coordinate possibleCoordinate;
        possibleCoordinate = new Coordinate(shotCoordinate.getX(), shotCoordinate.getY() - 1);
        if (Coordinate.isCoordinatesCorrect(possibleCoordinate) && !opponentsField.checkShotsCollision(
                possibleCoordinate)) {
            possibleVariants.add(possibleCoordinate);
        }
        possibleCoordinate = new Coordinate(shotCoordinate.getX() + 1, shotCoordinate.getY());
        if (Coordinate.isCoordinatesCorrect(possibleCoordinate) && !opponentsField.checkShotsCollision(
                possibleCoordinate)) {
            possibleVariants.add(possibleCoordinate);
        }
        possibleCoordinate = new Coordinate(shotCoordinate.getX(), shotCoordinate.getY() + 1);
        if (Coordinate.isCoordinatesCorrect(possibleCoordinate) && !opponentsField.checkShotsCollision(
                possibleCoordinate)) {
            possibleVariants.add(possibleCoordinate);
        }
        possibleCoordinate = new Coordinate(shotCoordinate.getX() - 1, shotCoordinate.getY());
        if (Coordinate.isCoordinatesCorrect(possibleCoordinate) && !opponentsField.checkShotsCollision(
                possibleCoordinate)) {
            possibleVariants.add(possibleCoordinate);
        }
    }
    
}
