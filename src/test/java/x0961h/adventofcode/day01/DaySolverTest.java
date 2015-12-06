package x0961h.adventofcode.day01;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 0x0961h on 06.12.2015.
 */
public class DaySolverTest {
    @Test
    public void test() {
        Assert.assertEquals(0, DaySolver.solve("(())"));
        Assert.assertEquals(0, DaySolver.solve("()()"));
        Assert.assertEquals(3, DaySolver.solve("((("));
        Assert.assertEquals(3, DaySolver.solve("(()(()("));
        Assert.assertEquals(3, DaySolver.solve("))((((("));
        Assert.assertEquals(-1, DaySolver.solve("())"));
        Assert.assertEquals(-1, DaySolver.solve("))("));
        Assert.assertEquals(-3, DaySolver.solve(")))"));
        Assert.assertEquals(-3, DaySolver.solve(")())())"));
    }
}
