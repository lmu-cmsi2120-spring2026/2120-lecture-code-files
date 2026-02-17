import java.util.*;
import org.junit.Test;

public class PrependTest {

    // Toy around with this number - see how changing it
    // affects how long the ArrayList prepend and LinkedList
    // prepend tests each take to run!
    private static int TEST_SIZE = 200000;

    @Test
    public void testArrayListPrepend() {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < TEST_SIZE; i++) {
            // [!] Adding i to index 0 = prepend operation
            arr.add(0, i);
        }
    }

    @Test
    public void testLinkedListPrepend() {
        LinkedList<Integer> arr = new LinkedList<>();
        for (int i = 0; i < TEST_SIZE; i++) {
            // [!] Adding i to index 0 = prepend operation
            arr.add(0, i);
        }
    }

}