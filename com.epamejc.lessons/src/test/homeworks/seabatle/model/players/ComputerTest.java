package homeworks.seabatle.model.players;

import homeworks.seabatle.myenum.StrikeResult;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ComputerTest {
    private int[] ship = {12, 13, 14, 15};
    private List<Integer> deckArea = Arrays.asList(2, 11, 13, 22);
    private Computer computer;

    @Before
    public void setUp() throws Exception {
        computer = new Computer();
    }

    @Test
    public void testAreaShoot() {
        computer.setCurrentTarget(12);
        computer.notifyShootResult(StrikeResult.WOUND);
        assertTrue(deckArea.contains(computer.shoot()));
    }

    @Test
    public void testKillShoot() {
        computer.setCurrentTarget(16);
        computer.notifyShootResult(StrikeResult.MISS);
        computer.setCurrentTarget(11);
        computer.notifyShootResult(StrikeResult.MISS);
        List<Integer> gorWoundedShip = new ArrayList<>();
        gorWoundedShip.add(13);
        gorWoundedShip.add(14);
        computer.setShip(gorWoundedShip);
        computer.setCurrentTarget(14);
        computer.notifyShootResult(StrikeResult.WOUND);
        List<Integer> gorShoots = new ArrayList<>();
        gorShoots.add(computer.shoot());
        computer.notifyShootResult(StrikeResult.WOUND);
        gorShoots.add(computer.shoot());
        computer.notifyShootResult(StrikeResult.KILL);
        System.out.println(gorShoots.toString());
        assertTrue(gorShoots.contains(12));
        assertTrue(gorShoots.contains(15));


        computer.setCurrentTarget(36);
        computer.notifyShootResult(StrikeResult.MISS);
        computer.setCurrentTarget(86);
        computer.notifyShootResult(StrikeResult.MISS);
        List<Integer> verWoundedShip = new ArrayList<>();
        verWoundedShip.add(56);
        verWoundedShip.add(66);
        computer.setShip(verWoundedShip);
        computer.setCurrentTarget(66);
        computer.notifyShootResult(StrikeResult.WOUND);
        List<Integer> shoots = new ArrayList<>();
        shoots.add(computer.shoot());
        computer.notifyShootResult(StrikeResult.WOUND);
        System.out.println("neb");
        shoots.add(computer.shoot());
        computer.notifyShootResult(StrikeResult.KILL);
        System.out.println(shoots);
        assertTrue(shoots.contains(46));
        assertTrue(shoots.contains(76));
        computer.shoot();
    }

    @Test
    public void testGetShip() {
        List<Integer> coords = Arrays.asList(10, 12, 12, 13);
        computer.setShip(coords);
        assertThat(coords, is(computer.getShip()));
    }

    @Test
    public void testRecursion() {
        computer.setCurrentTarget(26);
        computer.notifyShootResult(StrikeResult.MISS);
        computer.setCurrentTarget(37);
        computer.notifyShootResult(StrikeResult.MISS);
        computer.setCurrentTarget(35);
        computer.notifyShootResult(StrikeResult.MISS);
        List<Integer> coords = Arrays.asList(36);
        computer.setShip(coords);
        computer.shoot();
    }


}