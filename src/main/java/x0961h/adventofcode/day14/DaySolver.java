package x0961h.adventofcode.day14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 0x0961h on 18.12.2015.
 */
public class DaySolver {
    private static final boolean debug = false;

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources", "day14.data")));
        System.out.println("Result = " + solve(input, 2503));
    }

    private final static Pattern pat = Pattern.compile("(\\w+) can fly (\\d+) km/s for (\\d+) seconds, but then must rest for (\\d+) seconds\\.");

    public static int solve(String input, int simulationTime) {
        Optional<Integer> result = Arrays.stream(input.split("\n")).
                map(data -> {
                    Matcher mat = pat.matcher(data);
                    mat.find();

                    String name = mat.group(1);
                    int speed = Integer.parseInt(mat.group(2));
                    int activeTime = Integer.parseInt(mat.group(3));
                    int restTime = Integer.parseInt(mat.group(4));

                    return new ReindeerData(name, speed, activeTime, restTime);
                }).
                map(reindeer -> {
                    if (debug) System.out.println("Simulating " + reindeer.name + "...");
                    int beingActive = 0, km = 0;
                    for (int i = 0; i < simulationTime; i++) {
                        if (beingActive >= 0) {
                            km += reindeer.speed;
                            beingActive++;
                            if (debug) System.out.println(String.format(" - Running for %ss, distance = %s", beingActive, km));
                            if (beingActive == reindeer.activeTime) beingActive = -reindeer.restTime;
                        } else {
                            if (debug) System.out.println(String.format(" - Resting, %ss left, distance = %s", -beingActive, km));
                            beingActive++;
                        }
                    }

                    return km;
                }).
                max(Integer::compare);

        if (!result.isPresent()) throw new RuntimeException();
        return result.get();
    }

    private static class ReindeerData {
        public final String name;
        public final int speed;
        public final int activeTime;
        public final int restTime;

        public ReindeerData(String name, int speed, int activeTime, int restTime) {
            this.name = name;
            this.speed = speed;
            this.activeTime = activeTime;
            this.restTime = restTime;
        }
    }
}
