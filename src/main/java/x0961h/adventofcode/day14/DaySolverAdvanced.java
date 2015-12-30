package x0961h.adventofcode.day14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by 0x0961h on 18.12.2015.
 */
public class DaySolverAdvanced {
    private static final boolean debug = true;

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources", "day14.data")));
        System.out.println("Result = " + solve(input, 2503));
    }

    private final static Pattern pat = Pattern.compile("(\\w+) can fly (\\d+) km/s for (\\d+) seconds, but then must rest for (\\d+) seconds\\.");

    public static int solve(String input, int simulationTime) {
        List<ReindeerData> reindeers = Arrays.stream(input.split("\n")).
                map(data -> {
                    Matcher mat = pat.matcher(data);
                    mat.find();

                    String name = mat.group(1);
                    int speed = Integer.parseInt(mat.group(2));
                    int activeTime = Integer.parseInt(mat.group(3));
                    int restTime = Integer.parseInt(mat.group(4));

                    return new ReindeerData(name, speed, activeTime, restTime);
                }).
                collect(Collectors.toList());

        for (int i = 0; i < simulationTime; i++) {
            if (debug) System.out.println("Iteration #" + i);
            for (ReindeerData reindeer : reindeers) {
                if (reindeer.beingActive >= 0) {
                    reindeer.km += reindeer.speed;
                    reindeer.beingActive++;
                    if (debug) System.out.println(String.format(" - %s is running for %ss, distance = %s", reindeer.name, reindeer.beingActive, reindeer.km));
                    if (reindeer.beingActive == reindeer.activeTime) reindeer.beingActive = -reindeer.restTime;
                } else {
                    if (debug) System.out.println(String.format(" - %s is resting, %ss left, distance = %s", reindeer.name, -reindeer.beingActive, reindeer.km));
                    reindeer.beingActive++;
                }
            }

            if (debug) System.out.println();

            Optional<ReindeerData> leader = reindeers.stream().max((r1, r2) -> Integer.compare(r1.km, r2.km));
            if (!leader.isPresent()) throw new RuntimeException();
            leader.get().points++;

            if (debug) {
                System.out.println(String.format("Leader or this iteration is %s", leader.get().name));
                System.out.println();
                System.out.println("Standings after this iteration: ");
                reindeers.stream().sorted((r1, r2) -> Integer.compare(r1.points, r2.points)).forEach(r -> System.out.println(String.format(" - %s (%s)", r.name, r.points)));
                System.out.println();
            }

            if (debug) System.out.println();
        }

        return reindeers.stream().
                map(r -> r.points).
                max(Integer::compare).
                get();
    }

    private static class ReindeerData {
        public final String name;
        public final int speed;
        public final int activeTime;
        public final int restTime;
        public int beingActive;
        public int km;
        public int points;

        public ReindeerData(String name, int speed, int activeTime, int restTime) {
            this.name = name;
            this.speed = speed;
            this.activeTime = activeTime;
            this.restTime = restTime;
            this.beingActive = 0;
            this.km = 0;
            this.points = 0;
        }
    }
}
