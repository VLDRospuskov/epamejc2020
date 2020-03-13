package seabattleTest.battlefieldTest;

import homeworks.homework3.allInOne.Colors;
import homeworks.seabattle.battlefield.CellsToPrint;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CellsToPrintTest {

    CellsToPrint cellsToPrint = new CellsToPrint();

    @Test
    public void clearCellsTest () {

        List<Integer> shipPositions = new ArrayList<>();
        List<Integer> hitPositions = new ArrayList<>();
        List<Integer> missPositions = new ArrayList<>();
        List<Integer> deadShipsPositions = new ArrayList<>();

        String[] expected = Stream.generate(() -> " ")
                .limit(100)
                .toArray(String[]::new);

        String[] actual = cellsToPrint.initCells(shipPositions, hitPositions, missPositions,
                deadShipsPositions, true);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void allKindsOfCellsTest () {

        List<Integer> shipPositions = Stream.iterate(0, x -> x + 1)
                .limit(20)
                .collect(Collectors.toList());

        List<Integer> hitPositions = Stream.iterate(20, x -> x + 1)
                .limit(20)
                .collect(Collectors.toList());

        List<Integer> missPositions = Stream.iterate(40, x -> x + 1)
                .limit(20)
                .collect(Collectors.toList());

        List<Integer> deadShipsPositions = Stream.iterate(60, x -> x + 1)
                .limit(20)
                .collect(Collectors.toList());

        String[] expected = Stream.concat(Stream.concat(Stream.concat(Stream.concat(
                Stream.generate(() -> Colors.colors[6] + "■" + Colors.colors[0]).limit(20),
                Stream.generate(() -> Colors.colors[2] + "¤" + Colors.colors[0]).limit(20)),
                Stream.generate(() -> Colors.colors[7] + "x" + Colors.colors[0]).limit(20)),
                Stream.generate(() -> Colors.colors[2] + "□" + Colors.colors[0]).limit(20)),
                Stream.generate(() -> " ").limit(20))
                .toArray(String[]::new);

        String[] actual = cellsToPrint.initCells(shipPositions, hitPositions, missPositions,
                deadShipsPositions, true);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void hiddenAllKindsOfCellsTest () {

        List<Integer> shipPositions = Stream.iterate(0, x -> x + 1)
                .limit(20)
                .collect(Collectors.toList());

        List<Integer> hitPositions = Stream.iterate(20, x -> x + 1)
                .limit(20)
                .collect(Collectors.toList());

        List<Integer> missPositions = Stream.iterate(40, x -> x + 1)
                .limit(20)
                .collect(Collectors.toList());

        List<Integer> deadShipsPositions = Stream.iterate(60, x -> x + 1)
                .limit(20)
                .collect(Collectors.toList());

        String[] expected = Stream.concat(Stream.concat(Stream.concat(Stream.concat(
                Stream.generate(() -> " ").limit(20),
                Stream.generate(() -> Colors.colors[2] + "¤" + Colors.colors[0]).limit(20)),
                Stream.generate(() -> Colors.colors[7] + "x" + Colors.colors[0]).limit(20)),
                Stream.generate(() -> Colors.colors[2] + "□" + Colors.colors[0]).limit(20)),
                Stream.generate(() -> " ").limit(20))
                .toArray(String[]::new);

        String[] actual = cellsToPrint.initCells(shipPositions, hitPositions, missPositions,
                deadShipsPositions, false);

        Assert.assertArrayEquals(expected, actual);
    }
}
