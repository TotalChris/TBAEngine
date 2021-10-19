import junit.framework.TestCase;

public class UtilTest extends TestCase {

    public void testIsVowelWord() {
        assertFalse(Util.isVowelWord("Lol"));
        assertTrue(Util.isVowelWord("Ayy"));
    }
}