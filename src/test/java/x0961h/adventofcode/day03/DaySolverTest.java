package x0961h.adventofcode.day03;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 0x0961h on 06.12.2015.
 */
public class DaySolverTest {
    @Test
    public void test() {
        Assert.assertEquals(2, DaySolver.solve(">"));
        Assert.assertEquals(4, DaySolver.solve("^>v<"));
        Assert.assertEquals(2, DaySolver.solve("^v^v^v^v^v"));
    }
}
