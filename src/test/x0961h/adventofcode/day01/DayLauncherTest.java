package x0961h.adventofcode.day01;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 0x0961h on 06.12.2015.
 */
public class DayLauncherTest {
    @Test
    public void test() {
        Assert.assertEquals(0, DayLauncher.getFinalFloorForInput("(())"));
        Assert.assertEquals(0, DayLauncher.getFinalFloorForInput("()()"));
        Assert.assertEquals(3, DayLauncher.getFinalFloorForInput("((("));
        Assert.assertEquals(3, DayLauncher.getFinalFloorForInput("(()(()("));
        Assert.assertEquals(3, DayLauncher.getFinalFloorForInput("))((((("));
        Assert.assertEquals(-1, DayLauncher.getFinalFloorForInput("())"));
        Assert.assertEquals(-1, DayLauncher.getFinalFloorForInput("))("));
        Assert.assertEquals(-3, DayLauncher.getFinalFloorForInput(")))"));
        Assert.assertEquals(-3, DayLauncher.getFinalFloorForInput(")())())"));
    }
}
