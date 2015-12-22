package x0961h.adventofcode.day16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 0x0961h on 13.12.2015.
 */
public class DaySolver {
    private static final boolean debug = false;

    public static void main(String[] args) throws IOException {
        String aunts = new String(Files.readAllBytes(Paths.get("src/main/resources", "day16.data")));
        solve("children: 3\n" +
                "cats: 7\n" +
                "samoyeds: 2\n" +
                "pomeranians: 3\n" +
                "akitas: 0\n" +
                "vizslas: 0\n" +
                "goldfish: 5\n" +
                "trees: 3\n" +
                "cars: 2\n" +
                "perfumes: 1", aunts);
    }

    private final static Pattern pat = Pattern.compile("Sue (\\d+): (\\w+): (\\d+), (\\w+): (\\d+), (\\w+): (\\d+)");

    private enum Thing {
        CHILDREN, CATS, SAMOYEDS, POMERANIANS, AKITAS, VIZSLAS, GOLDFISH, TREES, CARS, PERFUMES
    }

    public static void solve(String output, String auntsData) {
        EnumMap<Thing, Integer> scan = new EnumMap<>(Thing.class);

        Arrays.stream(output.split("\n")).
                forEach(line -> {
                    String[] spl = line.split(": ");
                    scan.put(Thing.valueOf(spl[0].toUpperCase()), Integer.valueOf(spl[1]));
                });

        String[] aunts = auntsData.split("\n");

        Arrays.stream(aunts).
                forEach(aunt -> {
                    Matcher mat = pat.matcher(aunt);
                    mat.find();

                    int auntId = Integer.parseInt(mat.group(1));

                    int i = 0;
                    for (i = 0; i < 3; i++) {
                        Thing thing = Thing.valueOf(mat.group(2 + i * 2).toUpperCase());
                        int thingCount = Integer.parseInt(mat.group(2 + i * 2 + 1));
                        if (scan.get(thing) != thingCount) break;
                    }

                    if (i == 3) System.out.println(auntId);
                });
    }
}
