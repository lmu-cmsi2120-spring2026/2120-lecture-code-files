import static org.junit.Assert.*;
import org.junit.Test;

public class BurnymonTests {

    @Test
    public void testTakeDamage () {
        Burnymon burny = new Burnymon("Dave");
        assertEquals(15, burny.getHealth());
        burny.takeDamage(5, "dampy");
        assertEquals(10, burny.getHealth());
    }

    @Test
    public void testToString () {
        Burnymon burny = new Burnymon("Dave");
        assertEquals("Dave Dave", burny.toString());
    }

}
