package homeworks.seabatle.model.players;

import homeworks.seabatle.model.board.Field;
import homeworks.seabatle.model.board.ShipsRepository;
import homeworks.seabatle.servises.factories.ShipAutoGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserTest {
    private Player player;
    private Field field;
    private String name = "Alex";

    @Before
    public void setUp() throws Exception {
        ShipsRepository repository = new ShipAutoGenerator().getGeneratedRepository();
        field = new Field(repository);
        player = new User();
    }

    @Test
    public void testSetGetField() {
        player.setField(field);
        assertThat(field, is(player.getField()));
    }

    @Test
    public void testSetGetName() {
        player.setName(name);
        assertThat(name, is(player.getName()));
    }


}