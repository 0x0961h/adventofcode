package x0961h.adventofcode.day04;

import org.junit.Assert;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

/**
 * Created by 0x0961h on 06.12.2015.
 */
public class DaySolverTest {
    @Test
    public void test() throws NoSuchAlgorithmException {
        Assert.assertEquals(609043, DaySolver.solve("abcdef"));
        Assert.assertEquals(1048970, DaySolver.solve("pqrstuv"));
    }
}
