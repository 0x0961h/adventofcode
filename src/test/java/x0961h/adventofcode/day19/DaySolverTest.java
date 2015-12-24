package x0961h.adventofcode.day19;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by 0x0961h on 13.12.2015.
 */
public class DaySolverTest {
    @Test
    public void solutionTest() {
        Assert.assertEquals(4, DaySolver.solve("H => HO\nH => OH\nO => HH", "HOH"));
        Assert.assertEquals(7, DaySolver.solve("H => HO\nH => OH\nO => HH", "HOHOHO"));
        Assert.assertEquals(5, DaySolver.solve("H => HO\nH => OH\nO => HH\nLi => COOH\nMg => MgLiOHCl", "COCoLiH203Mg"));
    }
}
