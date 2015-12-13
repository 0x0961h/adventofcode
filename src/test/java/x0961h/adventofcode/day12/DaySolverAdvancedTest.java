package x0961h.adventofcode.day12;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by 0x0961h on 13.12.2015.
 */
public class DaySolverAdvancedTest {
    @Test
    public void solutionTest() {
        Assert.assertEquals(6, DaySolver.solve("[1,2,3]"));
        Assert.assertEquals(6, DaySolverAdvanced.solve("[1,2,3]"));

        Assert.assertEquals(6, DaySolver.solve("[1,{\"c\":\"red\",\"b\":2},3]"));
        Assert.assertEquals(4, DaySolverAdvanced.solve("[1,{\"c\":\"red\",\"b\":2},3]"));

        Assert.assertEquals(15, DaySolver.solve("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}"));
        Assert.assertEquals(0, DaySolverAdvanced.solve("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}"));

        Assert.assertEquals(15, DaySolver.solve("{\"a\":{\"d\":\"red\",\"e\":[1,2,3,4]},\"f\":5}"));
        Assert.assertEquals(5, DaySolverAdvanced.solve("{\"a\":{\"d\":\"red\",\"e\":[1,2,3,4]},\"f\":5}"));

        Assert.assertEquals(173, DaySolver.solve("{\"d\":{\"a\":{\"b\":\"red\",\"c\":4,\"d\":{\"g\":\"q\",\"h\":100},\"y\":34},\"z\":20},\"e\":[1,2,3,4],\"f\":5}"));
        Assert.assertEquals(35, DaySolverAdvanced.solve("{\"d\":{\"a\":{\"b\":\"red\",\"c\":4,\"d\":{\"g\":\"q\",\"h\":100},\"y\":34},\"z\":20},\"e\":[1,2,3,4],\"f\":5}"));

        Assert.assertEquals(6, DaySolver.solve("[1,\"red\",5]"));
        Assert.assertEquals(6, DaySolverAdvanced.solve("[1,\"red\",5]"));
        Assert.assertEquals(14, DaySolverAdvanced.solve("{\"a\":[1,\"red\",5],\"b\":{\"q\":5,\"p\":3}}"));
        Assert.assertEquals(6, DaySolverAdvanced.solve("{\"a\":[1,\"red\",5],\"b\":{\"red\":5,\"p\":3}}"));

        Assert.assertEquals(0, DaySolverAdvanced.solve("{\"d\":{\"e\":-14,\"a\":\"red\",\"d\":{\"c\":\"yellow\",\"a\":[-35,0],\"b\":\"orange\",\"d\":{\"e\":70,\"a\":\"green\",\"d\":\"blue\",\"j\":12,\"c\":69,\"h\":\"orange\",\"b\":92,\"g\":\"yellow\",\"f\":\"green\",\"i\":121}},\"c\":\"blue\",\"h\":14,\"b\":46,\"g\":62,\"f\":[179]}}"));
    }
}
