package homework.homework3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharMatrixTest {

    private CharMatrix charMatrix;

    @Before
    public void setup() {
        char[][] matrix = new char[][]{
                {'q', 'w', 'a', 's'},
                {'e', 'r', 'd', 'f'},
                {'t', 'y', 'g', 'h'},
                { 'z', 'x', 'c', 'v'}
        };
        charMatrix = new CharMatrix(matrix);
    }

    @Test
    public void toStringStrategyA() {
        assertEquals("qatg", charMatrix.toStringStrategyA());
    }

    @Test
    public void toStringStrategyB() {
        assertEquals("rfxv", charMatrix.toStringStrategyB());
    }
}