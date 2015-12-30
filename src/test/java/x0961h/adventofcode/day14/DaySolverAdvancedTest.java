package x0961h.adventofcode.day14;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 0x0961h on 18.12.2015.
 */
public class DaySolverAdvancedTest {
    @Test
    public void solutionTest() {
        Assert.assertEquals(688, DaySolverAdvanced.solve("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.\n" +
                "Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.", 1000));
    }
}
