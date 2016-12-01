package x0961h.adventofcode.day17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by 0x0961h on 13.12.2015.
 */
public class DaySolver {
    private static final boolean debug = false;

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources", "day17.data")));
        System.out.println("Result = " + solve(150, input));
    }

    public static long solve(int liters, String containersData) {
        List<Integer> containers = Arrays.stream(containersData.split("\n")).
                map(String::trim).
                map(Integer::parseInt).
                collect(Collectors.toList());

        System.out.println(containers);

        return IntStream.
                range(0, (int) Math.pow(2, containers.size())).
                map(i -> {
                    List<Integer> arr = String.
                            format("%" + containers.size() + "s", Integer.toBinaryString(i)).
                            replace(' ', '0').
                            chars().
                            boxed().
                            map(ch -> ch == '1' ? 1 : 0).
                            collect(Collectors.toList());

                    return IntStream.
                            range(0, arr.size()).
                            map(j -> containers.get(j) * arr.get(j)).
                            sum();
                }).
                filter(i -> i == liters).
                count();
    }
}
