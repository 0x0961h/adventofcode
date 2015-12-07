package x0961h.adventofcode.day06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 0x0961h on 07.12.2015.
 */
public class DaySolverAdvanced {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources", "day06.data")));
        System.out.println("Result = " + solve(input));
    }

    public static long solve(String input) {
        String[] commands = input.split("\n");
        int[][] lights = new int[1000][1000];
        Pattern pat = Pattern.compile("(turn on|turn off|toggle) (\\d+),(\\d+) through (\\d+),(\\d+)");

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
                            lights[x][y]++;
                            break;
                        case "turn off":
                            lights[x][y] = Math.max(lights[x][y] - 1, 0);
                            break;
                        case "toggle":
                            lights[x][y] += 2;
                            break;
                    }
                }
            }
        }

        long totalBrightness = 0L;
        for (int x = 0; x < lights.length; x++) {
            for (int y = 0; y < lights[x].length; y++) {
                totalBrightness += lights[x][y];
            }
        }

        return totalBrightness;
    }
}
