package x0961h.adventofcode.day02;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 0x0961h on 06.12.2015.
 */
public class DaySolverAdvancedTest {
    @Test
    public void test() {
        Assert.assertEquals(34, DaySolverAdvanced.solve(2, 3, 4));
        Assert.assertEquals(14, DaySolverAdvanced.solve(1, 1, 10));
    }
}
