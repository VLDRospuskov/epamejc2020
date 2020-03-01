package seabattle.java;

public class SeaBattle {

    public void run() {
        Field field = new Field();
        field.printField();
//        field.setShip();
//        Ship ship4 = new Ship(4, new Integer[]{2,1}, new Integer[]{2,4}, field);
//        Ship ship1 = new Ship(4, new Integer[]{0,0}, new Integer[]{0,3}, field);
        Ship ship2 = new Ship(4, new Integer[]{0,6}, new Integer[]{0,9}, field);
        field.printField();

    }

}
