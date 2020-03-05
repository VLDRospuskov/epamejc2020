package homeworks.seaBattle.logic;

import homeworks.seaBattle.data.Player;
import homeworks.seaBattle.data.enums.ShipType;
import org.junit.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.InputStream;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.setIn;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class InputOperatorTest {

    private static InputStream originalIn;

    @BeforeClass
    public static void initClass() {
        originalIn = in;
    }

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    /**
     * Testing {@link InputOperator#enterIndexes(Scanner, Player, PlayerShootingUtil)} for entering indices for shooting
     */
    @Test
    public void testEnterIndexesForShooting() {
        InputOperator testInputOperator = new InputOperator();
        Player botPlayer = new Player();
        botPlayer.fieldOperations().generateField();
        PlayerShootingUtil playerShootingUtil = new PlayerShootingUtil(botPlayer);
        systemInMock.provideLines("B 2");
        Scanner scanner = new Scanner(System.in);
        int[] expectedResult1 = {2, 2};
        int[] actualResult1 = testInputOperator.enterIndexes(scanner, botPlayer, playerShootingUtil);
        systemInMock.provideLines("exit");
        int[] actualResult2 = testInputOperator.enterIndexes(scanner, botPlayer, playerShootingUtil);

        assertThat(actualResult1, is(expectedResult1));
        assertThat(actualResult2, is(expectedResult1));
    }

    /**
     * Testing {@link InputOperator#enterIndexes(Scanner, FieldOperations, String)} for entering indices
     * for manual ship placement
     */
    @Test
    public void testEnterIndexesForPlacement() {
        InputOperator testInputOperator = new InputOperator();
        Player humanPlayer = new Player();
        FieldOperations fieldOperations = humanPlayer.fieldOperations();
        systemInMock.provideLines("B 2");
        Scanner scanner = new Scanner(System.in);
        int[] expectedResult1 = {2, 2};
        int[] actualResult1 = testInputOperator.enterIndexes(scanner,fieldOperations, ShipType.CRUISER.getType());
        assertThat(actualResult1, is(expectedResult1));
    }

    /**
     * Testing {@link InputOperator#enterDirection(Scanner, String)}
     */
    @Test
    public void enterDirection() {
        InputOperator testInputOperator = new InputOperator();
        Scanner scanner = new Scanner(System.in);
        systemInMock.provideLines(" left ");
        String expectedResult1 = "left";
        String actualResult1 = testInputOperator.enterDirection(scanner, ShipType.CRUISER.getType());
        systemInMock.provideLines("right");
        String expectedResult2 = "right";
        String actualResult2 = testInputOperator.enterDirection(scanner, ShipType.CRUISER.getType());
        Assert.assertEquals(expectedResult1, actualResult1);
        Assert.assertEquals(expectedResult2, actualResult2);
    }

    /**
     * Testing {@link InputOperator#isManualPlacementRequired(Scanner)}
     */
    @Test
    public void isManualPlacementRequired() {
        InputOperator testInputOperator = new InputOperator();
        Scanner scanner = new Scanner(System.in);
        systemInMock.provideLines(" Y ");
        boolean expectedResult1 = true;
        boolean actualResult1 = testInputOperator.isManualPlacementRequired(scanner);
        systemInMock.provideLines("N");
        boolean expectedResult2 = false;
        boolean actualResult2 = testInputOperator.isManualPlacementRequired(scanner);
        Assert.assertEquals(expectedResult1, actualResult1);
        Assert.assertEquals(expectedResult2, actualResult2);
    }

    @AfterClass
    public static void returnIn() {
        setIn(originalIn);
    }

}