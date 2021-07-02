import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String s1 = "a";
        String s2 = "aca";
        String s3 = " ";
        String s4 = "abaa";
        String s5 = "aabcaa";
        assertTrue(palindrome.isPalindrome(s1));
        assertTrue(palindrome.isPalindrome(s2));
        assertTrue(palindrome.isPalindrome(s3));
        assertFalse(palindrome.isPalindrome(s4));
        assertFalse(palindrome.isPalindrome(s5));
    }

    @Test
    public void testIsPalindromeOf() {
        OffByOne offByOne = new OffByOne();
        OffByN offByN = new OffByN(3);
        String s1 = "acedb";
        String s2 = "bddc";
        String s3 = " ";
        String s4 = "abfed";
        assertTrue(palindrome.isPalindrome(s1, offByOne));
        assertFalse(palindrome.isPalindrome(s2, offByOne));
        assertTrue(palindrome.isPalindrome(s3, offByOne));
        assertTrue(palindrome.isPalindrome(s4, offByN));
    }
}
