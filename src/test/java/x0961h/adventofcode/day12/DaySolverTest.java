package x0961h.adventofcode.day12;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by 0x0961h on 13.12.2015.
 */
public class DaySolverTest {
    @Test
    public void numbersInVarNamesTest() {
        Assert.assertEquals(9, DaySolver.solve("{\"var1\",5,\"var2\",4}"));
        Assert.assertEquals(11, DaySolver.solve("{\"var1\":3,\"var2\":8}"));
        Assert.assertEquals(6, DaySolver.solve("{\"var1\":2,\"var2\":4}"));
        Assert.assertEquals(12, DaySolver.solve("{\"var-1\":6,\"var2\":6}"));
        Assert.assertEquals(22, DaySolver.solve("{\"var_1\":10,\"var-2\":12}"));
    }

    @Test
    public void soultionTest() {
        Assert.assertEquals(6, DaySolver.solve("[1,2,3]"));
        Assert.assertEquals(6, DaySolver.solve("{\"a\":2,\"b\":4}"));
        Assert.assertEquals(3, DaySolver.solve("[[[3]]]"));
        Assert.assertEquals(3, DaySolver.solve("{\"a\":{\"b\":4},\"c\":-1}"));
        Assert.assertEquals(0, DaySolver.solve("{\"a\":[-1,1]}"));
        Assert.assertEquals(0, DaySolver.solve("[-1,{\"a\":1}]"));
        Assert.assertEquals(0, DaySolver.solve("[]"));
        Assert.assertEquals(0, DaySolver.solve("{}"));
    }
}
