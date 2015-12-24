package x0961h.adventofcode.day11;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by 0x0961h on 13.12.2015.
 */
public class DaySolverTest {
    @Test
    public void validationTest() {
        Assert.assertFalse("Length test failed", DaySolver.validate("asdlkjsadlkjdslkajdl"));
        Assert.assertFalse("Length test failed", DaySolver.validate("fljdh"));
        Assert.assertFalse("False positive", DaySolver.validate("hijklmmn"));
        Assert.assertFalse("False positive", DaySolver.validate("abbceffg"));
        Assert.assertFalse("False positive", DaySolver.validate("abbcegjk"));
        Assert.assertTrue("False negative", DaySolver.validate("abcdffaa"));
        Assert.assertTrue("False negative", DaySolver.validate("ghjaabcc"));
    }

    @Test
    public void incrementPasswordTest() {
        Assert.assertEquals("Incorrect increment", "abd", DaySolver.increment("abc"));
        Assert.assertEquals("Incorrect increment", "aca", DaySolver.increment("abz"));
        Assert.assertEquals("Incorrect increment", "baa", DaySolver.increment("azz"));
        Assert.assertEquals("Incorrect increment", "aaa", DaySolver.increment("zzz"));
    }

    @Test
    public void incrementOfIOLTest() {
        Assert.assertEquals("Incorrect increment", "aaj", DaySolver.increment("aah"));
        Assert.assertEquals("Incorrect increment", "aap", DaySolver.increment("aan"));
        Assert.assertEquals("Incorrect increment", "aam", DaySolver.increment("aak"));
        Assert.assertEquals("Incorrect increment", "aaja", DaySolver.increment("aahz"));
        Assert.assertEquals("Incorrect increment", "aapa", DaySolver.increment("aanz"));
        Assert.assertEquals("Incorrect increment", "aama", DaySolver.increment("aakz"));
    }

    @Test
    public void solutionTest() {
        Assert.assertEquals("abcdffaa", DaySolver.solve("abcdefgh"));
        Assert.assertEquals("ghjaabcc", DaySolver.solve("ghijklmn"));
    }
}
