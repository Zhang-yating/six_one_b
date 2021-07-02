import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChar() {
        char c1 = 'a';
        char c2 = 'b';
        char c3 = 'c';
        assertTrue(offByOne.equalChars(c1, c2));
        assertFalse(offByOne.equalChars(c1, c3));
    }


}
