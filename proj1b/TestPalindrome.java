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
    //Task 3A
    @Test
    public void testPalindrome(){
        //assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("caad"));
    }

    @Test
    public void testOffByOnePalindrome(){
        OffByOne offByOne = new OffByOne();
        assertTrue(palindrome.isPalindrome("cacd",offByOne));
    }
}     //
// Uncomment this class once you've created your Palindrome class.