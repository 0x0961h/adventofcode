package x0961h.adventofcode.day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by 0x0961h on 06.12.2015.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        System.out.println(
                "Result = " + Files.lines(Paths.get("src/main/resources", "day05.data")).
                        map(DaySolver::isNice).
                        filter(isNice -> isNice).
                        count()
        );
    }

    public static Boolean isNice(String input) {
        if (input.chars().
                filter(ch -> ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u').
                count() < 3) return false;

        if (input.contains("ab") || input.contains("cd") || input.contains("pq") || input.contains("xy"))
            return false;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i - 1) == input.charAt(i)) return true;
        }

        return false;
    }
}
