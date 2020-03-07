package homeworks.seabatle.board;


import homeworks.seabatle.exception.ShipCreationRequestException;
import homeworks.seabatle.exception.ShipNotFoundException;
import homeworks.seabatle.ship.Ship;

import java.util.List;

public interface ShipsRepository {
   Ship getShip(int coordinate) throws ShipNotFoundException;
   String addShip(Ship ship) throws ShipCreationRequestException;
   void updateShip(Ship ship);
   List<Ship> getAll();
   int getSize();
   void delete(Ship ship);
}
