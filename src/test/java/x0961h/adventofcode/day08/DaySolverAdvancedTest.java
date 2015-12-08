package x0961h.adventofcode.day08;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 0x0961h on 08.12.2015.
 */
public class DaySolverAdvancedTest {
    @Test
    public void test() {
        Assert.assertEquals(2,  DaySolverAdvanced.codeLength("\"\""));
        Assert.assertEquals(6,  DaySolverAdvanced.escapedLength("\"\""));

        Assert.assertEquals(5,  DaySolverAdvanced.codeLength("\"abc\""));
        Assert.assertEquals(9,  DaySolverAdvanced.escapedLength("\"abc\""));

        Assert.assertEquals(10, DaySolverAdvanced.codeLength("\"aaa\\\"aaa\""));
        Assert.assertEquals(16,  DaySolverAdvanced.escapedLength("\"aaa\\\"aaa\""));

        Assert.assertEquals(6,  DaySolverAdvanced.codeLength("\"\\x27\""));
        Assert.assertEquals(11,  DaySolverAdvanced.escapedLength("\"\\x27\""));

        Assert.assertEquals(19,  DaySolverAdvanced.solve(
                "\"\"\n" +
                        "\"abc\"\n" +
                        "\"aaa\\\"aaa\"\n" +
                        "\"\\x27\""
        ));
    }

    @Test
    public void escaperTest() {
        {
            String line = "\"\"";
            String res = DaySolverAdvanced.escape(line);
            Assert.assertEquals("\"\\\"\\\"\"", res);
        }

        {
            String line = "\"\\x27\"";
            String res = DaySolverAdvanced.escape(line);
            Assert.assertEquals("\"\\\"\\\\x27\\\"\"", res);
        }
    }
}
