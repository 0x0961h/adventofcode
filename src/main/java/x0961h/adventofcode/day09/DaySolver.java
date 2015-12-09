package x0961h.adventofcode.day09;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by 0x0961h on 09.12.2015.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
//        String input = new String(Files.readAllBytes(Paths.get("src/main/resources", "day08.data")));
//        System.out.println("Result = " + solve(input));
    }

    public static int solve(String input) {
        return 0;
    }

    private class Node {

    }

    private static final int INF = Integer.MAX_VALUE;

    public static void solve(String[] cities, int[][] distances) {
        int[] dist = IntStream.range(0, cities.length).map(r -> r == 0 ? 0 : INF).toArray();
        Set<Integer> sptSet = new HashSet<>();

        while (sptSet.size() < cities.length) {
            iteration(cities, distances, dist, sptSet);
        }
        System.out.println(Arrays.toString(dist));
        System.out.println("[0, 4, 12, 19, 21, 11, 9, 8, 14]");
    }

    private static void iteration(String[] cities, int[][] distances, int[] dist, Set<Integer> sptSet) {
        int min = INF;
        int minIndex = -1;

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] <= min && !sptSet.contains(i)) {
                min = dist[i];
                minIndex = i;
            }
        }

        sptSet.add(minIndex);
        for (int i = 0; i < cities.length; i++) {
            if (minIndex == i) continue;
            if (distances[minIndex][i] != -1 && !sptSet.contains(i) && dist[i] >= dist[minIndex] + distances[minIndex][i]) {
                dist[i] = dist[minIndex] + distances[minIndex][i];
            }
        }
    }
}
