package x0961h.adventofcode.day06;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 0x0961h on 06.12.2015.
 */
public class DaySolverAdvancedTest {
    @Test
    public void exceptionTest() {
        boolean exceptionCaught = false;

        try {
            DaySolverAdvanced.solve("turn on q,0 through 999,999");
        } catch (RuntimeException e) {
            Assert.assertEquals("Illegal input!", e.getMessage());
            exceptionCaught = true;
        }

        Assert.assertTrue("Exception was not thrown!", exceptionCaught);
    }

    @Test
    public void test() {
        Assert.assertEquals(1, DaySolverAdvanced.solve("turn on 0,0 through 0,0"));
        Assert.assertEquals(2000000, DaySolverAdvanced.solve("toggle 0,0 through 999,999"));
    }
}
