package x0961h.adventofcode.day17;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by 0x0961h on 13.12.2015.
 */
public class DaySolverTest {
    @Test
    public void solutionTest() {
        Assert.assertEquals(4, DaySolver.solve("20\n15\n10\n5\n5", 25));
    }

    @Test
    public void shiftTest() {
        Assert.assertEquals(Arrays.asList(1, 3, 4, 5, 2), DaySolver.shiftLeft(Arrays.asList(1, 2, 3, 4, 5), 1, 4));
        Assert.assertEquals(Arrays.asList(2, 3, 4, 5, 1), DaySolver.shiftLeft(Arrays.asList(1, 2, 3, 4, 5), 0, 4));
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5), DaySolver.shiftLeft(Arrays.asList(1, 2, 3, 4, 5), 4, 4));
        Assert.assertEquals(Arrays.asList(2, 3, 4, 5, 1), DaySolver.shiftLeft(Arrays.asList(1, 2, 3, 4, 5)));
    }
}
