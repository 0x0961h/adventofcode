package x0961h.adventofcode.day03;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 0x0961h on 07.12.2015.
 */
public class DaySolverAdvancedTest {
    @Test
    public void test() {
        Assert.assertEquals(3, DaySolverAdvanced.solve("^v"));
        Assert.assertEquals(3, DaySolverAdvanced.solve("^>v<"));
        Assert.assertEquals(11, DaySolverAdvanced.solve("^v^v^v^v^v"));
    }
}
