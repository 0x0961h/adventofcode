package x0961h.adventofcode.day08;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 0x0961h on 08.12.2015.
 */
public class DaySolverTest {
    @Test
    public void test() {
        Assert.assertEquals(2,  DaySolver.codeLength("\"\""));
        Assert.assertEquals(0,  DaySolver.stringLength("\"\""));

        Assert.assertEquals(5,  DaySolver.codeLength("\"abc\""));
        Assert.assertEquals(3,  DaySolver.stringLength("\"abc\""));

        Assert.assertEquals(10, DaySolver.codeLength("\"aaa\\\"aaa\""));
        Assert.assertEquals(7,  DaySolver.stringLength("\"aaa\\\"aaa\""));

        Assert.assertEquals(6,  DaySolver.codeLength("\"\\x27\""));
        Assert.assertEquals(1,  DaySolver.stringLength("\"\\x27\""));

        Assert.assertEquals(7,  DaySolver.codeLength("\"\\\\x27\""));
        Assert.assertEquals(4,  DaySolver.stringLength("\"\\\\x27\""));

//        Assert.assertEquals(12,  DaySolver.solve(
//                "\"\"\n" +
//                        "\"abc\"\n" +
//                        "\"aaa\\\"aaa\"\n" +
//                        "\"\\x27\""
//        ));
    }

    @Test
    public void escaperTest() {
        {
            String line = "\"\"";
            String res = DaySolver.unescape(line.substring(1, line.length() - 1));
            Assert.assertEquals("", res);
        }

        {
            String line = "\"\\\\\"";
            String res = DaySolver.unescape(line.substring(1, line.length() - 1));
            Assert.assertEquals("\\", res);
        }

        {
            String line = "\"\\\\\\\\\"";
            String res = DaySolver.unescape(line.substring(1, line.length() - 1));
            Assert.assertEquals("\\\\", res);
        }

        {
            String line = "\"\\x27\"";
            String res = DaySolver.unescape(line.substring(1, line.length() - 1));
            Assert.assertEquals("@", res);
        }

        {
            String line = "\"\\\\x27\"";
            String res = DaySolver.unescape(line.substring(1, line.length() - 1));
            Assert.assertEquals("\\x27", res);
        }

        {
            String line = "\"fdan\\\\\\x9e\"";
            String res = DaySolver.unescape(line.substring(1, line.length() - 1));
            Assert.assertEquals("fdan\\@", res);
        }
    }
}
