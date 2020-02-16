package homework.homework2.matrix;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharMatrixTest {

    private CharMatrix charMatrix;

    @Before
    public void setup() {
        char[][] matrix = new char[][]{
                {'q', 'w'},
                {'e', 'r'},
                {'t', 'y'}
        };
        charMatrix = new CharMatrix(matrix);
    }

    @Test
    public void toStringStrategyA() {
        assertEquals("qt", charMatrix.toStringStrategyA());
    }

    @Test
    public void toStringStrategyB() {
        assertEquals("r", charMatrix.toStringStrategyB());
    }
}