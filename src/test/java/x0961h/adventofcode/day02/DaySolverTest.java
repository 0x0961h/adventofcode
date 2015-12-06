package x0961h.adventofcode.day02;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 0x0961h on 06.12.2015.
 */
public class DaySolverTest {
    @Test
    public void test() {
        Assert.assertEquals(58, DaySolver.solve(2, 3, 4));
        Assert.assertEquals(43, DaySolver.solve(1, 1, 10));
    }
}
