package x0961h.adventofcode.day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

/**
 * Created by 0x0961h on 07.12.2015.
 */
public class DaySolverAdvanced {
    public static void main(String[] args) throws IOException {
        System.out.println(
                "Result = " + Files.lines(Paths.get("src/main/resources", "day05.data")).
                        map(DaySolverAdvanced::isNice).
                        filter(isNice -> isNice).
                        count()
        );
    }

    private static Pattern nicePattern1 = Pattern.compile("([a-z]{2,2}).*\\1");
    private static Pattern nicePattern2 = Pattern.compile("([a-z]).\\1");

    public static Boolean isNice(String input) {
        if (!nicePattern2.matcher(input).find()) return false;
        return nicePattern1.matcher(input).find();
    }
}
