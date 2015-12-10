package x0961h.adventofcode.day10;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by 0x0961h on 10.12.2015.
 */
public class DaySolverTest {
    @Test
    public void test() {
        Assert.assertEquals("11", DaySolver.solve("1"));
        Assert.assertEquals("21", DaySolver.solve("11"));
        Assert.assertEquals("1211", DaySolver.solve("21"));
        Assert.assertEquals("111221", DaySolver.solve("1211"));
        Assert.assertEquals("312211", DaySolver.solve("111221"));
    }
}
