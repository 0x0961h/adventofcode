package x0961h.adventofcode.day17;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by 0x0961h on 13.12.2015.
 */
public class DaySolverTest {
    @Test
    public void solutionTest() {
        Assert.assertEquals(4, DaySolver.solve(25,
                        "20\n" +
                        "15\n" +
                        "10\n" +
                        "5\n" +
                        "5"
        ));
    }
}
