package seabattle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        //Assist assist = new Assist(new Coordinate())
        
        int direction = ship.getDirection();
        switch (direction) {
            case 0:
                if (ship.getFirstCoordinate()
                        .getX() > 0) {
                    assistSet.add(new Assist(new Coordinate(ship.getFirstCoordinate()
                                                                .getX() - 1,
                                                            ship.getFirstCoordinate()
                                                                .getY())));
                }
                if (ship.getFirstCoordinate()
                        .getX() < 9) {
                    assistSet.add(new Assist(new Coordinate(ship.getFirstCoordinate()
                                                                .getX() + 1,
                                                            ship.getFirstCoordinate()
                                                                .getY())));
                    
                }
                if (ship.getFirstCoordinate()
                        .getY() > 0) {
                    assistSet.add(new Assist(new Coordinate(ship.getFirstCoordinate()
                                                                .getX(),
                                                            ship.getFirstCoordinate()
                                                                .getY() - 1)));
                }
                if (ship.getFirstCoordinate()
                        .getY() < 9) {
                    assistSet.add(new Assist(new Coordinate(ship.getFirstCoordinate()
                                                                .getX(),
                                                            ship.getFirstCoordinate()
                                                                .getY() + 1)));
                }
                if (ship.getFirstCoordinate()
                        .getX() > 0 && ship.getFirstCoordinate()
                                           .getY() > 0) {
                    assistSet.add(new Assist(new Coordinate(ship.getFirstCoordinate()
                                                                .getX() - 1,
                                                            ship.getFirstCoordinate()
                                                                .getY() - 1)));
                }
                if (ship.getFirstCoordinate()
                        .getX() < 9 && ship.getFirstCoordinate()
                                           .getY() > 0) {
                    assistSet.add(new Assist(new Coordinate(ship.getFirstCoordinate()
                                                                .getX() + 1,
                                                            ship.getFirstCoordinate()
                                                                .getY() - 1)));
                }
                if (ship.getFirstCoordinate()
                        .getX() < 9 && ship.getFirstCoordinate()
                                           .getY() < 9) {
                    assistSet.add(new Assist(new Coordinate(ship.getFirstCoordinate()
                                                                .getX() + 1,
                                                            ship.getFirstCoordinate()
                                                                .getY() + 1)));
                }
                if (ship.getFirstCoordinate()
                        .getX() > 0 && ship.getFirstCoordinate()
                                           .getY() < 9) {
                    assistSet.add(new Assist(new Coordinate(ship.getFirstCoordinate()
                                                                .getX() - 1,
                                                            ship.getFirstCoordinate()
                                                                .getY() + 1)));
                }
                break;
    
            case 1:
                if (ship.getFirstCoordinate()
                        .getX() > 0) {
                    assistSet.add(new Assist(new Coordinate(ship.getFirstCoordinate()
                                                                .getX() - 1,
                                                            ship.getFirstCoordinate()
                                                                .getY())));
                }
                if (ship.getFirstCoordinate()
                        .getX() > 0 && ship.getFirstCoordinate()
                                           .getY() > 0) {
                    assistSet.add(new Assist(new Coordinate(ship.getFirstCoordinate()
                                                                .getX() - 1,
                                                            ship.getFirstCoordinate()
                                                                .getY() - 1)));
                }
                if (ship.getFirstCoordinate()
                        .getX() > 0 && ship.getFirstCoordinate()
                                           .getY() < 9) {
                    assistSet.add(new Assist(new Coordinate(ship.getFirstCoordinate()
                                                                .getX() - 1,
                                                            ship.getFirstCoordinate()
                                                                .getY() + 1)));
                }
                for (int i = 0; i < ship.getLength(); i++) {
                    if (ship.getFirstCoordinate()
                            .getY() > 0) {
                        assistSet.add(new Assist(new Coordinate(ship.getFirstCoordinate()
                                                                    .getX() + i,
                                                                ship.getFirstCoordinate()
                                                                    .getY() - 1)));
                    }
                    if (ship.getFirstCoordinate()
                            .getY() < 9) {
                        assistSet.add(new Assist(new Coordinate(ship.getFirstCoordinate()
                                                                    .getX() + i,
                                                                ship.getFirstCoordinate()
                                                                    .getY() + 1)));
                    }
                }
                if (ship.getSecondCoordinate()
                        .getX() < 9) {
                    assistSet.add(new Assist(new Coordinate(ship.getSecondCoordinate()
                                                                .getX() + 1,
                                                            ship.getSecondCoordinate()
                                                                .getY())));
                }
                if (ship.getSecondCoordinate()
                        .getX() < 9 && ship.getSecondCoordinate()
                                           .getY() > 0) {
                    assistSet.add(new Assist(new Coordinate(ship.getSecondCoordinate()
                                                                .getX() + 1,
                                                            ship.getSecondCoordinate()
                                                                .getY() - 1)));
                }
                if (ship.getSecondCoordinate()
                        .getX() < 9 && ship.getSecondCoordinate()
                                           .getY() < 9) {
                    assistSet.add(new Assist(new Coordinate(ship.getSecondCoordinate()
                                                                .getX() + 1,
                                                            ship.getSecondCoordinate()
                                                                .getY() + 1)));
                }
                break;
            case 2:
                if (ship.getFirstCoordinate()
                        .getY() > 0) {
                    assistSet.add(new Assist(new Coordinate(ship.getFirstCoordinate()
                                                                .getX(),
                                                            ship.getFirstCoordinate()
                                                                .getY() - 1)));
                }
                
                if (ship.getFirstCoordinate()
                        .getY() > 0 && ship.getFirstCoordinate()
                                           .getX() > 0) {
                    assistSet.add(new Assist(new Coordinate(ship.getFirstCoordinate()
                                                                .getX() - 1,
                                                            ship.getFirstCoordinate()
                                                                .getY() - 1)));
                }
                
                if (ship.getFirstCoordinate()
                        .getY() > 0 && ship.getFirstCoordinate()
                                           .getX() < 9) {
                    assistSet.add(new Assist(new Coordinate(ship.getFirstCoordinate()
                                                                .getX() + 1,
                                                            ship.getFirstCoordinate()
                                                                .getY() - 1)));
                }
                
                for (int i = 0; i < ship.getLength(); i++) {
                    if (ship.getFirstCoordinate()
                            .getX() < 9) {
                        assistSet.add(new Assist(new Coordinate(ship.getFirstCoordinate()
                                                                    .getX() + 1,
                                                                ship.getFirstCoordinate()
                                                                    .getY() + i)));
                    }
                    if (ship.getFirstCoordinate()
                            .getX() > 0) {
                        assistSet.add(new Assist(new Coordinate(ship.getFirstCoordinate()
                                                                    .getX() - 1,
                                                                ship.getFirstCoordinate()
                                                                    .getY() + i)));
                    }
                }
                
                if (ship.getSecondCoordinate()
                        .getY() < 9) {
                    assistSet.add(new Assist(new Coordinate(ship.getSecondCoordinate()
                                                                .getX(),
                                                            ship.getSecondCoordinate()
                                                                .getY() + 1)));
                }
                if (ship.getSecondCoordinate()
                        .getY() < 9 && ship.getSecondCoordinate()
                                           .getX() < 9) {
                    assistSet.add(new Assist(new Coordinate(ship.getSecondCoordinate()
                                                                .getX() + 1,
                                                            ship.getSecondCoordinate()
                                                                .getY() + 1)));
                }
                if (ship.getSecondCoordinate()
                        .getY() < 9 && ship.getSecondCoordinate()
                                           .getX() > 0) {
                    assistSet.add(new Assist(new Coordinate(ship.getSecondCoordinate()
                                                                .getX() - 1,
                                                            ship.getSecondCoordinate()
                                                                .getY() + 1)));
                }
                break;
    
        }
    }
    
    public void fillListOfShips() {
        
        Coordinate first;
        Coordinate second;
        View view = new View();
        while (ships.size() != 10) {
            printState();
            
            first = new Coordinate().input();
            second = new Coordinate().input();
            if (Coordinate.checkCoordinates(first, second)) {
                Ship ship = new Ship(first, second);
                if (first.getX() > second.getX() || first.getY() > second.getY()) {
                    ship = new Ship(second, first);
                }
                
                ships.add(ship);
                //  System.out.println(ship.getDirection());
                addPointsAroundShip(ship);
                view.updateFieldView(this);
                view.printField(this);
                // TODO: 15-Mar-20 коллизия кораблей
                // TODO: 15-Mar-20 ограничение кол-ва кораблей по типу
            } else {
                System.out.println(ships);
                System.out.println("Wrong coordinates");
            }
        }
        
    }
    
    public boolean checkShipCollision(Ship ship) {
        // TODO: 16-Mar-20 Функция проверки пересечения частей корабля с Ship или Assist
        return false;
    }
    
    public void printState() {
        System.out.printf("There are %s ship(s) on a filed.\n%s Battleship (length of 4)\n%s Cruiser (length of 3)" +
                          "\n%s Destroyer (length of 2)\n%s Torpedo boat (length of 1)\n\n", ships.size(),
                          ships.stream()
                               .map(Ship::getLength)
                               .filter(integer -> integer == 4)
                               .count(),
                          ships.stream()
                               .map(Ship::getLength)
                               .filter(integer -> integer == 3)
                               .count(),
                          ships.stream()
                               .map(Ship::getLength)
                               .filter(integer -> integer == 2)
                               .count(),
                          ships.stream()
                               .map(Ship::getLength)
                               .filter(integer -> integer == 1)
                               .count());
        
    }
    
    public List<Ship> fillRandomListOfShips() {
        // TODO: 16-Mar-20 Случайное заполнение списка кораблей
        return null;
    }
    
}
