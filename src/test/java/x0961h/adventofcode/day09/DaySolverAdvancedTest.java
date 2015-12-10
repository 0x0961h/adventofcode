package x0961h.adventofcode.day09;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by 0x0961h on 07.12.2015.
 */
public class DaySolverAdvancedTest {
    @Test
    public void test() {
        Assert.assertEquals(982, DaySolverAdvanced.solve("London to Dublin = 464\n" +
                "London to Belfast = 518\n" +
                "Dublin to Belfast = 141"));
    }
}
