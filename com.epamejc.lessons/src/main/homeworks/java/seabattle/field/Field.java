package homeworks.java.seabattle.field;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Field {

    public static Logger log = Logger.getLogger(Field.class.getName());

    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;

    private char[][] cells;
    private IFieldObject[][] objects;

    private Coordinatepointer[] neighbours;


    public Field() {
        cells = new char[HEIGHT][WIDTH];
        objects = new IFieldObject[WIDTH][HEIGHT];

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

    public void addObject(IFieldObject fieldObject) {
        Coordinatepointer position = new Coordinatepointer();

        if (isValidCoordinate(fieldObject.getPosition())) {
            objects[position.x][position.y] = fieldObject;
        } else {
            log.log(Level.WARNING, "Can't add object.");
        }
    }

    public boolean isValidCoordinate(Coordinatepointer point) {
        return point.x >= 0 && point.x < WIDTH && point.y >= 0 && point.y <= HEIGHT;
    }

    public boolean isCollide(Coordinatepointer position) {
        return objects[position.x][position.y] != null;
    }

    public boolean hasNeighbours(Coordinatepointer position) {

        boolean result = false;

        for (Coordinatepointer p : neighbours) {
            Coordinatepointer neighbour = new Coordinatepointer(position.x + p.x, position.y + p.y);

            if (isValidCoordinate(neighbour) && objects[neighbour.x][neighbour.y] != null) {
                result = true;
                break;
            }
        }
        return result;
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
    }

    public void draw() {

        update();
        int coordinateX = 1;
        char coordinateY = 'A';

        System.out.print("   ");
        for (int i = 0; i < 10; i++) {
            System.out.print(coordinateY++ + " ");
        }
        System.out.println();

        for (int y = 0; y < HEIGHT; y++) {
            if (coordinateX < HEIGHT) {
                System.out.print(coordinateX++ + " |");
            } else {
                System.out.print(coordinateX++ + "|");
            }
            for (int x = 0; x < WIDTH; x++) {
                cells[x][y] = '_';
                System.out.print(cells[x][y]);
                System.out.print('|');
            }
            System.out.println();
        }
    }
}
