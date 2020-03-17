package seabattle;

import homeworks.InputReader;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Field {
    
    List<Ship> ships = new ArrayList<>(10);
    Set<Assist> assistSet = new HashSet<>();
    List<Shots> shots = new ArrayList<>();
    
    public Field(List<Ship> ships, Set<Assist> assistSet, List<Shots> shots) {
        this.ships = ships;
        this.assistSet = assistSet;
        this.shots = shots;
    }
    
    public Field() {
    }
    
    public List<Ship> getShips() {
        return ships;
    }
    
    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }
    
    public Set<Assist> getAssistSet() {
        return assistSet;
    }
    
    public void setAssistSet(Set<Assist> assistSet) {
        this.assistSet = assistSet;
    }
    
    public List<Shots> getShots() {
        return shots;
    }
    
    public void setShots(List<Shots> shots) {
        this.shots = shots;
    }
    
    public void addPointsAroundShip(Ship ship) {
        for (Coordinate coordinate :
                ship.getShipParts()) {
            if (coordinate.getX() > 0 && coordinate.getY() > 0) {
                assistSet.add(new Assist(new Coordinate(coordinate.getX() - 1, coordinate.getY() - 1)));
            }
            if (coordinate.getY() > 0 && !ship.getShipParts()
                                              .contains(new Coordinate(coordinate.getX(),
                                                                       coordinate.getY() - 1))) {
                assistSet.add(new Assist(new Coordinate(coordinate.getX(), coordinate.getY() - 1)));
            }
            if (coordinate.getX() < 9 && coordinate.getY() > 0) {
                assistSet.add(new Assist(new Coordinate(coordinate.getX() + 1, coordinate.getY() - 1)));
            }
            if (coordinate.getX() > 0 && !ship.getShipParts()
                                              .contains(new Coordinate(coordinate.getX() - 1,
                                                                       coordinate.getY()))) {
                assistSet.add(new Assist(new Coordinate(coordinate.getX() - 1, coordinate.getY())));
            }
            if (coordinate.getX() < 9 && !ship.getShipParts()
                                              .contains(new Coordinate(coordinate.getX() + 1,
                                                                       coordinate.getY()))) {
                assistSet.add(new Assist(new Coordinate(coordinate.getX() + 1, coordinate.getY())));
            }
            if (coordinate.getX() > 0 && coordinate.getY() < 9) {
                assistSet.add(new Assist(new Coordinate(coordinate.getX() - 1, coordinate.getY() + 1)));
            }
            if (coordinate.getY() < 9 && !ship.getShipParts()
                                              .contains(new Coordinate(coordinate.getX(),
                                                                       coordinate.getY() + 1))) {
                assistSet.add(new Assist(new Coordinate(coordinate.getX(), coordinate.getY() + 1)));
            }
            if (coordinate.getX() < 9 && coordinate.getY() < 9) {
                assistSet.add(new Assist(new Coordinate(coordinate.getX() + 1, coordinate.getY() + 1)));
            }
        }
    }
    
    public void selectFillStrategy() {
        System.out.println("Input \'1\' for manual ship placement");
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
        View view = new View();
        view.printField(this);
        while (ships.size() != 10) {
            printState();
            first = new Coordinate().input();
            second = new Coordinate().input();
            if (Coordinate.checkCoordinates(first, second)) {
                Ship ship = new Ship(first, second);
                if (checkNoShipCollision(ship) && checkCorrectAmountOfShips(ship)) {
                    //System.out.println("No collision!");
                    ships.add(ship);
                    addPointsAroundShip(ship);
                    view.updateFieldView(this);
                    view.printField(this);
                } else {
                    System.out.println("You need to place 4 ships of length 1, 3 ships of length 2, 2 ships of length" +
                                       " 3, 1 ship of length 4 in empty squares");
                }
            } else {
                System.out.println(ships);
                System.out.println("Wrong coordinates");
            }
        }
        
    }
    
    public boolean checkNoShipCollision(Ship ship) {
        Stream<Coordinate> coordinateOneStream = ships.stream()
                                                      .map(Ship::getShipParts)
                                                      .flatMap(Collection::stream);
        Stream<Coordinate> coordinateTwoStream = assistSet.stream()
                                                          .map(Assist::getAssistPoint);
        Stream<Coordinate> concat = Stream.concat(coordinateOneStream, coordinateTwoStream);
        List<Coordinate> coordinateList = concat.collect(Collectors.toList());
        List<Coordinate> shipParts = ship.getShipParts();
        return Collections.disjoint(coordinateList, shipParts);
    }
    
    public boolean checkCorrectAmountOfShips(Ship ship) {
        switch (ship.getLength()) {
            case 1:
                return getCountByLength(1) < 4;
            case 2:
                return getCountByLength(2) < 3;
            case 3:
                return getCountByLength(3) < 2;
            case 4:
                return getCountByLength(4) < 1;
            default:
                return false;
        }
    }
    
    public void printState() {
        System.out.printf("There are %s ship(s) on a filed.\n%s Battleship (length of 4)\n%s Cruiser (length of 3)" +
                          "\n%s Destroyer (length of 2)\n%s Torpedo boat (length of 1)\n\n", ships.size(),
                          getCountByLength(4),
                          getCountByLength(3),
                          getCountByLength(2),
                          getCountByLength(1));
        
    }
    
    public void fillListOfShipsRandomly() {
        int state = 0;
        while (ships.size() != 10) {
            fillListOfShipsDependingOnLength(4, 1);
            if (getCountByLength(4) == 1) {
                fillListOfShipsDependingOnLength(3, 2);
            }
            if (getCountByLength(4) == 1 && getCountByLength(3) == 2) {
                fillListOfShipsDependingOnLength(2, 3);
            }
            if (getCountByLength(4) == 1 && getCountByLength(3) == 2 && getCountByLength(2) == 3) {
                fillListOfShipsDependingOnLength(1, 4);
            }
        }
    }
    
    private void fillListOfShipsDependingOnLength(int length, int requiredAmountOfLength) {
        int state;
        int firstX = new Random().nextInt(10);
        int firstY = new Random().nextInt(10);
        if (getCountByLength(length) < requiredAmountOfLength) {
            state = length - 1;
            Coordinate firstCoordinate = new Coordinate(firstX, firstY);
            List<Coordinate> possibleVariants = new ArrayList<>();
            addPossibleVariantsToList(firstX, firstY, firstCoordinate, possibleVariants, 0, -state);
            addPossibleVariantsToList(firstX, firstY, firstCoordinate, possibleVariants, state, 0);
            addPossibleVariantsToList(firstX, firstY, firstCoordinate, possibleVariants, 0, state);
            addPossibleVariantsToList(firstX, firstY, firstCoordinate, possibleVariants, -state, 0);
            View view = new View();
            if (possibleVariants.size() > 0) {
                Ship ship = selectRandomShip(firstCoordinate, possibleVariants);
                ships.add(ship);
                addPointsAroundShip(ship);
                view.updateFieldView(this);
                printState();
                view.printField(this);
            }
        }
    }
    
    private Ship selectRandomShip(Coordinate firstCoordinate, List<Coordinate> possibleVariants) {
        int random = new Random().nextInt(possibleVariants.size());
        Coordinate secondCoordinate = possibleVariants.get(random);
        return new Ship(firstCoordinate, secondCoordinate);
    }
    
    private void addPossibleVariantsToList(
            int firstX, int firstY, Coordinate firstCoordinate, List<Coordinate> possibleVariants, int addToXState,
            int addToYState) {
        Coordinate secondCoordinate;
        secondCoordinate = new Coordinate(firstX + addToXState, firstY + addToYState);
        if (Coordinate.checkCoordinates(firstCoordinate, secondCoordinate)) {
            Ship ship = new Ship(firstCoordinate, secondCoordinate);
            if (checkNoShipCollision(ship) && checkCorrectAmountOfShips(ship)) {
                possibleVariants.add(secondCoordinate);
            }
        }
    }
    
    private long getCountByLength(int length) {
        return ships.stream()
                    .map(Ship::getLength)
                    .filter(integer -> integer == length)
                    .count();
    }
    
}
