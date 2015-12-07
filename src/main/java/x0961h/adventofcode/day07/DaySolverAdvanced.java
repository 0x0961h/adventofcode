package x0961h.adventofcode.day07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Created by 0x0961h on 07.12.2015.
 */
public class DaySolverAdvanced {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources", "day07_advanced.data")));
        Map<String, Integer> solution = DaySolver.solve(input);
        System.out.println("Result = " + solution.get("a"));
    }
}
