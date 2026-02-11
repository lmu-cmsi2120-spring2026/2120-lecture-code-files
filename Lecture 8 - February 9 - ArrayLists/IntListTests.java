import org.junit.Test;
import static org.junit.Assert.*;

public class IntListTests {
    @Test
    public void testAppendAndRemoveAt() {
        IntArrayList test = new IntArrayList();
        test.append(2);
        test.append(4);
        test.append(8);
        test.removeAt(1);
        assertEquals("[2, 8]", test.toString());
    }
}
