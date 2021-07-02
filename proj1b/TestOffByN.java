import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    OffByN offByN = new OffByN(4);

    @Test
    public void testOffByN() {
        char c1 = 'a';
        char c2 = 'e';
        char c3 = 'c';
        assertTrue(offByN.equalChars(c1, c2));
        assertFalse(offByN.equalChars(c1, c3));
    }
}
