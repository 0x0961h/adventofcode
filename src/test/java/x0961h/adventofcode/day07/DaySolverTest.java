package x0961h.adventofcode.day07;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by 0x0961h on 06.12.2015.
 */
public class DaySolverTest {
    @Test
    public void test() {
        Map<String, Integer> data = DaySolver.solve(
                "123 -> x\n" +
                "456 -> y\n" +
                "x AND y -> d\n" +
                "x OR y -> e\n" +
                "x LSHIFT 2 -> f\n" +
                "y RSHIFT 2 -> g\n" +
                "NOT x -> h\n" +
                "NOT y -> i"
        );

        Assert.assertEquals(72, (int)data.get("d"));
        Assert.assertEquals(507, (int)data.get("e"));
        Assert.assertEquals(492, (int) data.get("f"));
        Assert.assertEquals(114, (int)data.get("g"));
        Assert.assertEquals(65412, (int)data.get("h"));
        Assert.assertEquals(65079, (int)data.get("i"));
        Assert.assertEquals(123, (int)data.get("x"));
        Assert.assertEquals(456, (int)data.get("y"));
    }
}
