package homeworks.seabattle.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Ship {

    public List<Integer> coordinates = new ArrayList<>();

    public Ship(List<Integer> coordinates) {

        this.coordinates = coordinates;
    }
}
