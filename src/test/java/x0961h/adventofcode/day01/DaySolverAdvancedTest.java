package x0961h.adventofcode.day01;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 0x0961h on 06.12.2015.
 */
public class DaySolverAdvancedTest {
    @Test
    public void test() {
        Assert.assertEquals(1, DaySolverAdvanced.solve(")"));
        Assert.assertEquals(5, DaySolverAdvanced.solve("()())"));
    }
}
