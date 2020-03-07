package com.epamejc.lessons.src.homework.seabattle.Utils;

import com.epamejc.lessons.src.homework.seabattle.Map.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemErrRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class InputUtilsTest {
    @Rule
    public final SystemErrRule systemErrRule = new SystemErrRule().enableLog();
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    InputUtils inputUtils;

    @Test
    public void getGameOptionNormalInput1() throws IOException {
        inputUtils = new InputUtils(new BufferedReader(new InputStreamReader(System.in)));
        systemInMock.provideLines("1");
        int option = inputUtils.getGameOption();
        assertEquals(1, option);

    }

    @Test
    public void getGameOptionNormalInput2() throws IOException {
        inputUtils = new InputUtils(new BufferedReader(new InputStreamReader(System.in)));
        systemInMock.provideLines("2");
        int option = inputUtils.getGameOption();
        assertEquals(2, option);
    }

    @Test
    public void getGameOptionErrorInput() throws IOException {
        inputUtils = new InputUtils(new BufferedReader(new InputStreamReader(System.in)));
        systemInMock.provideLines("3", "      ", "awdefsghj", "2345", "2");
        int option = inputUtils.getGameOption();
        assertEquals(2, option);
        assertFalse(systemErrRule.getLog().isEmpty());
    }

    @Test
    public void getNameErrorEmptyInput() throws IOException {
        String normalName = "sdfghj";
        String str = "       \n" +
                normalName + "\n да\n";
        initInputUtilsWithSystemIn(str);
        String name = inputUtils.getPlayerName();
        assertEquals(normalName, name);
        assertFalse(systemErrRule.getLog().isEmpty());
    }

    @Test
    public void getNameErrorMoreThan50Input() throws IOException {
        String moreThan50Name = String.format("%51s", "a");
        String normalName = "sdfghj";
        String str = moreThan50Name + "\n" +
                normalName + "\n да\n";
        initInputUtilsWithSystemIn(str);
        String name = inputUtils.getPlayerName();
        assertEquals(normalName, name);
        assertFalse(systemErrRule.getLog().isEmpty());
    }

    @Test
    public void getCellWrongLength() throws IOException {
        String longCell = "А 10\n";
        String normalCell = "А10\n";
        initInputUtilsWithSystemIn(longCell + normalCell);
        inputUtils.getCell();
        assertFalse(systemErrRule.getLog().isEmpty());
    }

    @Test
    public void getCellWrongLetter() throws IOException {
        String wrongLetterCell = "F10\n";
        String normalCell = "А10\n";
        initInputUtilsWithSystemIn(wrongLetterCell + normalCell);
        inputUtils.getCell();
        assertFalse(systemErrRule.getLog().isEmpty());
    }

    @Test
    public void getCellWrongNumber() throws IOException {
        String wrongNumCell1 = "А11\n";
        String wrongNumCell2 = "А0\n";
        String normalCell = "А10\n";
        initInputUtilsWithSystemIn(wrongNumCell1 + wrongNumCell2 + normalCell);
        inputUtils.getCell();
        assertFalse(systemErrRule.getLog().isEmpty());
    }

    @Test
    public void getCellWrongPosition() throws IOException {
        String wrongNumCell1 = "10А\n";
        String normalCell = "А10\n";
        initInputUtilsWithSystemIn(wrongNumCell1 + normalCell);
        inputUtils.getCell();
        assertFalse(systemErrRule.getLog().isEmpty());
    }

    @Test
    public void getCellNormal() throws IOException {
        for (String letter : BattleMap.letters) {
            for (int i = 1; i < 11; i++) {
                initInputUtilsWithSystemIn(letter + i + "\n");
                Cell cell = inputUtils.getCell();
                assertEquals(letter, cell.getLetter());
                assertEquals(i, cell.getNumber());
                assertEquals(CellStatus.EMPTY, cell.getStatus());
            }
        }
    }

    @Test
    public void getCellLowCaseLetter() throws IOException {
        for (String letter : BattleMap.letters) {
            initInputUtilsWithSystemIn(letter.toLowerCase() + 1 + "\n");
            Cell cell = inputUtils.getCell();
            assertEquals(letter, cell.getLetter());
            assertEquals(1, cell.getNumber());
            assertEquals(CellStatus.EMPTY, cell.getStatus());
        }
    }

    @Test
    public void getShipLength1() throws IOException {
        String cell = "а1\n";
        initInputUtilsWithSystemIn(cell);
        Ship ship = inputUtils.getShip(1);
        assertEquals(1, ship.getSize());
    }

    @Test
    public void getShipLengthMoreThanOneLength() throws IOException {
        String cell = "а1\n";
        String cell2 = "а2\n";
        initInputUtilsWithSystemIn(cell + cell2);
        Ship ship = inputUtils.getShip(2);
        assertEquals(2, ship.getSize());
    }

    @Test
    public void getShipLengthMoreThanOneLengthDiagonalCells() throws IOException {
        String diagonalCells = "а1\nб2\n";
        String cell = "а1\n";
        String cell2 = "а2\n";
        initInputUtilsWithSystemIn(diagonalCells + cell + cell2);
        Ship ship = inputUtils.getShip(2);
        assertEquals(2, ship.getSize());
        assertFalse(systemErrRule.getLog().isEmpty());
    }

    @Test
    public void fillMapByInputNormal() throws IOException {
        String ship4Length = "а1\nа4\n";
        String ship3Length1 = "В1\nв3\n";
        String ship3Length2 = "д1\nд3\n";
        String ship2Length1 = "ж1\nж2\n";
        String ship2Length2 = "ж4\nж5\n";
        String ship2Length3 = "ж7\nж8\n";
        String ship1Length = "а10\nв10\nд10\nи10\n";
        BattleMap map = new BattleMap("", new EventHandler());
        initInputUtilsWithSystemIn(ship4Length + ship3Length1 + ship3Length2 + ship2Length1 + ship2Length2
                + ship2Length3 + ship1Length);
        inputUtils.fillMapByInput(map);
        assertEquals(10, map.getNumberAliveShips());

    }

    @Test
    public void fillMapByInputWrongOrder() throws IOException {
        String ship4Length = "а1\nа4\n";
        String ship3Length1 = "В1\nв3\n";
        String ship3Length2 = "д1\nд3\n";
        String ship2Length1 = "ж1\nж2\n";
        String ship2Length2 = "ж4\nж5\n";
        String ship2Length3 = "ж7\nж8\n";
        String ship1Length = "а10\nв10\nд10\nи10\n";
        BattleMap map = new BattleMap("", new EventHandler());
        initInputUtilsWithSystemIn(ship3Length1 + ship4Length + ship3Length1 + ship3Length2 + ship2Length1
                + ship2Length2 + ship2Length3 + ship1Length);
        inputUtils.fillMapByInput(map);
        assertEquals(10, map.getNumberAliveShips());
        assertFalse(systemErrRule.getLog().isEmpty());
    }

    @Test
    public void fillMapByInputWrongPosition() throws IOException {
        String ship4Length = "а1\nа4\n";
        String ship3Length1WrongPosition = "а1\nа3\n";
        String ship3Length1 = "В1\nв3\n";
        String ship3Length2 = "д1\nд3\n";
        String ship2Length1 = "ж1\nж2\n";
        String ship2Length2 = "ж4\nж5\n";
        String ship2Length3 = "ж7\nж8\n";
        String ship1Length = "а10\nв10\nд10\nи10\n";
        BattleMap map = new BattleMap("", new EventHandler());
        initInputUtilsWithSystemIn(ship4Length + ship3Length1WrongPosition + ship3Length1
                + ship3Length2 + ship2Length1 + ship2Length2 + ship2Length3 + ship1Length);
        inputUtils.fillMapByInput(map);
        assertEquals(10, map.getNumberAliveShips());
        assertFalse(systemErrRule.getLog().isEmpty());
    }

    private void initInputUtilsWithSystemIn(String str) {
        System.setIn(new BufferedInputStream(new ByteArrayInputStream(str.getBytes())));
        inputUtils = new InputUtils(new BufferedReader(new InputStreamReader(System.in)));
    }


}