import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class FlikTest {
    @Test
    public void testIsSameNumber() {
        int input = 129;
        assertTrue(Flik.isSameNumber(input,input));
    }
}
