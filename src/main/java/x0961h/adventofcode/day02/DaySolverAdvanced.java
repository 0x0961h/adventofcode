package x0961h.adventofcode.day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by 0x0961h on 06.12.2015.
 */
public class DaySolverAdvanced {
    public static void main(String[] args) throws IOException {
        long total = Files.
                lines(Paths.get("src/main/resources", "day02.data")).
                map(line -> {
                    Integer[] dimensions = Arrays.asList(line.split("x")).
                            stream().
                            map(Integer::parseInt).
                            toArray(Integer[]::new);

                    return solve(
                            dimensions[0],
                            dimensions[1],
                            dimensions[2]
                    );
                }).
                collect(Collectors.summarizingLong(Integer::intValue)).
                getSum();

        System.out.println("Result = " + total);
    }

    public static int solve(int l, int w, int h) {
        int bow = l * w * h;

        return Math.min(l + w, Math.min(l + h, w + h)) * 2 + bow;
    }
}
