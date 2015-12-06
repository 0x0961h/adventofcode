package x0961h.adventofcode.day06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 0x0961h on 06.12.2015.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources", "day06.data")));
        System.out.println("Result = " + solve(input));
    }

    public static int solve(String input) {
        String[] commands = input.split("\n");
        boolean[][] lights = new boolean[1000][1000];
        Pattern pat = Pattern.compile("(turn on|turn off|toggle) (\\d+),(\\d+) through (\\d+),(\\d+)");

        int litLightsCount = 0;

        for (String cmdLine : commands) {
            Matcher mat = pat.matcher(cmdLine);
            if (!mat.find()) throw new RuntimeException("Illegal input!");

            int x0 = Integer.parseInt(mat.group(2));
            int y0 = Integer.parseInt(mat.group(3));
            int x1 = Integer.parseInt(mat.group(4));
            int y1 = Integer.parseInt(mat.group(5));

            String cmd = mat.group(1).toLowerCase();
            for (int x = x0; x <= x1; x++) {
                for (int y = y0; y <= y1; y++) {
                    switch (cmd) {
                        case "turn on":
                            if (!lights[x][y]) litLightsCount++;
                            lights[x][y] = true;
                            break;
                        case "turn off":
                            if (lights[x][y]) litLightsCount--;
                            lights[x][y] = false;
                            break;
                        case "toggle":
                            lights[x][y] = !lights[x][y];
                            if (lights[x][y]) litLightsCount++; else litLightsCount--;
                            break;
                    }
                }
            }
        }

        return litLightsCount;
    }
}
