package x0961h.adventofcode.day06;

import org.junit.Assert;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

/**
 * Created by 0x0961h on 06.12.2015.
 */
public class DaySolverTest {
    @Test
    public void exceptionTest() throws NoSuchAlgorithmException {
        boolean exceptionCaught = false;

        try {
            DaySolver.solve("turn on q,0 through 999,999");
        } catch (RuntimeException e) {
            Assert.assertEquals("Illegal input!", e.getMessage());
            exceptionCaught = true;
        }

        Assert.assertTrue("Exception was not thrown!", exceptionCaught);
    }

    @Test
    public void test() throws NoSuchAlgorithmException {
        Assert.assertEquals(1000000, DaySolver.solve("turn on 0,0 through 999,999"));
        Assert.assertEquals(1000000 - 1000, DaySolver.solve("turn on 0,0 through 999,999\ntoggle 0,0 through 999,0"));
        Assert.assertEquals(1000000 - 1000 - 4, DaySolver.solve("turn on 0,0 through 999,999\ntoggle 0,0 through 999,0\nturn off 499,499 through 500,500"));
    }
}
