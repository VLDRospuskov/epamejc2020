package homeworks.java.seabattle.field;

import homeworks.java.seabattle.player.BasePlayer;
import homeworks.java.seabattle.player.Player;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Field {

    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    public static Logger log = Logger.getLogger(Field.class.getName());

    private char[] head;
    private char[][] cells;
    private IFieldObject[][] objects;
    private Coordinatepointer[] neighbours;

    public Field() {
        head = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        cells = new char[HEIGHT][WIDTH];
        objects = new IFieldObject[WIDTH][HEIGHT];

        for (int y = 0; y < HEIGHT; ++y) {

            for (int x = 0; x < WIDTH; ++x) {

                cells[x][y] = ' ';
            }
        }

        neighbours = new Coordinatepointer[8];
        neighbours[0] = new Coordinatepointer(-1, -1);
        neighbours[1] = new Coordinatepointer(-1, 0);
        neighbours[2] = new Coordinatepointer(-1, 1);
        neighbours[3] = new Coordinatepointer(0, 1);
        neighbours[4] = new Coordinatepointer(1, 1);
        neighbours[5] = new Coordinatepointer(1, 0);
        neighbours[6] = new Coordinatepointer(1, -1);
        neighbours[7] = new Coordinatepointer(0, -1);
    }

    public IFieldObject[][] getObjects() {
        return objects;
    }

    public Coordinatepointer[] getNeighbours() {
        return neighbours;
    }

    public char[] getHead() {
        return head;
    }

    public void addObject(IFieldObject fieldObject) {
        Coordinatepointer position = fieldObject.getPosition();

        if (isValidCoordinate(fieldObject.getPosition())) {
            objects[position.x][position.y] = fieldObject;
        } else {
            log.log(Level.WARNING, "Can't add object.");
        }
    }

    public boolean isValidCoordinate(Coordinatepointer point) {
        return point.x >= 0 && point.x < WIDTH && point.y >= 0 && point.y < HEIGHT;
    }

    public boolean isCollide(Coordinatepointer position) {
        return objects[position.x][position.y] != null;
    }

    public boolean hasNeighbours(Coordinatepointer position) {

        boolean result = false;

        for (Coordinatepointer p : neighbours) {
            Coordinatepointer neighbour = new Coordinatepointer(position.x + p.x, position.y + p.y);

            if (isValidCoordinate(neighbour)) {
                if (objects[neighbour.x][neighbour.y] != null) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public void draw(boolean isUpdate) {
        System.out.println("---- Your field ----");

        if (isUpdate) update();
        int coordX = 0;
        int coordY = 1;

        System.out.print(' ');
        for (int x = 0; x < WIDTH; x++) {

            System.out.print(' ');
            System.out.print(head[coordX]);

            coordX += 1;
        }

        System.out.println();

        for (int y = 0; y < HEIGHT; y++) {

            System.out.print(coordY++);

            for (int x = 0; x < WIDTH; x++) {

                if (!(x == 0 && coordY == 11)) {
                    System.out.print(' ');
                }
                System.out.print(cells[x][y]);
            }
            System.out.println('|');
        }
        System.out.println();
    }

    public void clean() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                cells[x][y] = ' ';
            }
        }
    }

    public void update() {
        clean();
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                IFieldObject currentObject = objects[x][y];

                if (currentObject != null) {
                    Coordinatepointer position = currentObject.getPosition();
                    cells[position.x][position.y] = currentObject.getView();
                }
            }
        }

        List<Coordinatepointer> attackedPoints = BasePlayer.getListOfAttackedPointsForBot();
        for (Coordinatepointer point : attackedPoints) {
            IFieldObject currentObject = objects[point.x][point.y];
            if (currentObject != null && currentObject.getView() == 'X') {
                cells[point.x][point.y] = currentObject.getView();
            } else if (currentObject == null) {
                cells[point.x][point.y] = '0';
            }
        }
    }

    public void drawBotField() {
        System.out.println("---- Bot Field ----");

        updateBattleFieldForBot();
        int coordX = 0;
        int coordY = 1;

        System.out.print(' ');
        for (int x = 0; x < WIDTH; x++) {

            System.out.print(' ');
            System.out.print(head[coordX]);

            coordX += 1;
        }

        System.out.println();

        for (int y = 0; y < HEIGHT; y++) {

            System.out.print(coordY++);

            for (int x = 0; x < WIDTH; x++) {

                if (!(x == 0 && coordY == 11)) {
                    System.out.print(' ');
                }
                System.out.print(cells[x][y]);
            }
            System.out.println('|');
        }
        System.out.println();
    }

    public void updateBattleFieldForBot() {
        clean();
        List<Coordinatepointer> attackedPoints = Player.getListOfAttackedPoints();
        for (Coordinatepointer point : attackedPoints) {
            IFieldObject currentObject = objects[point.x][point.y];
            if (currentObject != null && currentObject.getView() == 'X') {
                cells[point.x][point.y] = currentObject.getView();
            } else if (currentObject == null) {
                cells[point.x][point.y] = '0';
            } else {
                cells[point.x][point.y] = ' ';
            }
        }
    }
}
