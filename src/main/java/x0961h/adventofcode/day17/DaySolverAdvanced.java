package x0961h.adventofcode.day17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by 0x0961h on 13.12.2015.
 */
public class DaySolverAdvanced {
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

        List<List<Integer>> combos = IntStream.
                range(0, (int) Math.pow(2, containers.size())).
                mapToObj(
                        i -> String.
                                format("%" + containers.size() + "s", Integer.toBinaryString(i)).
                                replace(' ', '0').
                                chars().
                                boxed().
                                map(ch -> ch == '1' ? 1 : 0).
                                collect(Collectors.toList())
                ).
                filter(
                        arr -> IntStream.
                                range(0, arr.size()).
                                map(j -> containers.get(j) * arr.get(j)).
                                sum() == liters
                ).
                map(
                        arr -> IntStream.
                                range(0, arr.size()).
                                map(j -> containers.get(j) * arr.get(j)).
                                boxed().
                                filter(i -> i != 0).
                                collect(Collectors.toList())
                ).
                collect(Collectors.toList());

        Integer minComboSize = combos.stream().
                min(Comparator.comparingInt(List::size)).
                map(List::size).
                get();

        return combos.stream().
                filter(l -> l.size() == minComboSize).
                collect(Collectors.toList()).
                size();
    }
}
