package x0961h.adventofcode.day19;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by 0x0961h on 13.12.2015.
 */
public class DaySolverAdvancedTest {
    @Test
    public void solutionTest() {
        Assert.assertEquals(3, DaySolverAdvanced.solve("e => H\ne => O\nH => HO\nH => OH\nO => HH", "HOH"));
//        Assert.assertEquals(6, DaySolverAdvanced.solve("e => H\ne => O\nH => HO\nH => OH\nO => HH", "HOHOHO"));
    }
}
