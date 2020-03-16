package seabattle;

import homeworks.InputReader;

import java.util.HashMap;
import java.util.Map;

public class Coordinate {
    
    public final static Map<String, Integer> lettersToNumbers = createMap();
    private int x;
    private int y;
    
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Coordinate() {
    }
    
    private static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 0);
        map.put("b", 1);
        map.put("c", 2);
        map.put("d", 3);
        map.put("e", 4);
        map.put("f", 5);
        map.put("g", 6);
        map.put("h", 7);
        map.put("i", 8);
        map.put("j", 9);
        
        return map;
    }
    
    public static boolean checkCoordinates(Coordinate first, Coordinate second) {
        return first.getX() >= 0 && first.getX() < 10 && first.getY() >= 0 && first.getY() < 10 &&
               (first.getX() == second.getX() || first.getY() == second.getY()) &&
               (Math.abs(first.getX() - second.getX()) <= 3 && Math.abs(first.getY() - second.getY()) <= 3);
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public Coordinate input() {
        int x = -1;
        int y = -1;
        System.out.println("Input column letter");
        String columnString = InputReader.nextString();
        if (lettersToNumbers.containsKey(columnString.toLowerCase())) {
            x = lettersToNumbers.get(columnString.toLowerCase());
        }
        System.out.println("Input row number");
        int rowInt = InputReader.nextInt();
        if (rowInt - 1 >= 0 && rowInt - 1 < 10) {
            y = rowInt - 1;
        }
        return new Coordinate(x, y);
    }
    
    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getX();
        result = prime * result + getY();
        return result;
    }
    
    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coordinate that = (Coordinate) o;
        return getX() == that.getX() &&
               getY() == that.getY();
    }
    
}
