package x0961h.adventofcode.day05;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 0x0961h on 06.12.2015.
 */
public class DaySolverTest {
    @Test
    public void test() {
        Assert.assertEquals(true, DaySolver.isNice("ugknbfddgicrmopn"));
        Assert.assertEquals(true, DaySolver.isNice("aaa"));
        Assert.assertEquals(false, DaySolver.isNice("jchzalrnumimnmhp"));
        Assert.assertEquals(false, DaySolver.isNice("haegwjzuvuyypxyu"));
        Assert.assertEquals(false, DaySolver.isNice("dvszwmarrgswjxmb"));
    }
}
