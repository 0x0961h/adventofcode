package x0961h.adventofcode.day05;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 0x0961h on 07.12.2015.
 */
public class DaySolverAdvancedTest {
    @Test
    public void test() {
        Assert.assertEquals(true, DaySolverAdvanced.isNice("qjhvhtzxzqqjkmpb"));
        Assert.assertEquals(true, DaySolverAdvanced.isNice("xxyxx"));
        Assert.assertEquals(false, DaySolverAdvanced.isNice("uurcxstgmygtbstg"));
        Assert.assertEquals(false, DaySolverAdvanced.isNice("ieodomkazucvgmuy"));
    }
}
