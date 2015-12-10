package x0961h.adventofcode.day09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by 0x0961h on 09.12.2015.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources", "day09.data")));
        System.out.println("Result = " + solve(input));
    }

    public static int solve(String input) {
        Map<Map.Entry<String, String>, Integer> temp = new HashMap<>();
        Map<String, Integer> cities = new HashMap<>();
        String[] names;
        int[][] distances;

        Arrays.stream(input.split("\r?\n")).
                forEach((line) -> {
                    String from, to;
                    int routeLength;

                    {
                        String[] data = line.split(" = ");
                        routeLength = Integer.parseInt(data[1]);
                        String[] placesData = data[0].split(" to ");
                        from = placesData[0];
                        to = placesData[1];
                    }

                    temp.put(new AbstractMap.SimpleEntry<>(from, to), routeLength);
                    if (!cities.containsKey(from)) cities.put(from, cities.size());
                    if (!cities.containsKey(to)) cities.put(to, cities.size());
                });

        names = new String[cities.size()];
        for (Map.Entry<String, Integer> entry : cities.entrySet()) {
            names[entry.getValue()] = entry.getKey();
        }

        distances = new int[cities.size()][cities.size()];
        for (Map.Entry<Map.Entry<String, String>, Integer> entry : temp.entrySet()) {
            distances[cities.get(entry.getKey().getKey())][cities.get(entry.getKey().getValue())] = entry.getValue();
            distances[cities.get(entry.getKey().getValue())][cities.get(entry.getKey().getKey())] = entry.getValue();
        }

        return iteration(cities.size(), distances, new ArrayList<>());
    }

    private static int iteration(int citiesCount, int[][] distances, List<Integer> levels) {
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < citiesCount; i++) {
            if (!levels.isEmpty() && levels.contains(i)) continue;
            levels.add(i);

            if (levels.size() == citiesCount) {
                result = Math.min(result, calcPathLength(levels, distances));
            } else {
                result = Math.min(result, iteration(citiesCount, distances, levels));
            }

            levels.remove(levels.size() - 1);
        }

        return result;
    }

    private static int calcPathLength(List<Integer> levels, int[][] distances) {
        int length = 0;

        for (int i = 0; i < levels.size() - 1; i++) {
            length += distances[levels.get(i)][levels.get(i + 1)];
        }

        return length;
    }
}
