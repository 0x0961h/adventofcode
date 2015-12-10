package x0961h.adventofcode.day09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by 0x0961h on 09.12.2015.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources", "day09.data")));
        solve(input);
//        System.out.println("Result = " + solve(input));
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

                    System.out.println(line);
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

        System.out.println();
        System.out.println(Arrays.deepToString(distances).replaceAll("\\], \\[", "]\n[").replaceAll("\\]\\]", "]").replaceAll("\\[\\[", "["));
        System.out.println();

        for (int city1 = 0; city1 < cities.size(); city1++) {
            List<Integer> alreadyVisited1 = new ArrayList<>();
            alreadyVisited1.add(city1);

            for (int city2 = 0; city2 < cities.size(); city2++) {
                if (alreadyVisited1.contains(city2)) continue;
                List<Integer> alreadyVisited2 = new ArrayList<>(alreadyVisited1);
                alreadyVisited2.add(city2);

                for (int city3 = 0; city3 < cities.size(); city3++) {
                    if (alreadyVisited2.contains(city3)) continue;
                    List<Integer> alreadyVisited3 = new ArrayList<>(alreadyVisited2);
                    alreadyVisited3.add(city3);

                    for (int city4 = 0; city4 < cities.size(); city4++) {
                        if (alreadyVisited3.contains(city4)) continue;
                        List<Integer> alreadyVisited4 = new ArrayList<>(alreadyVisited3);
                        alreadyVisited4.add(city4);

                        for (int city5 = 0; city5 < cities.size(); city5++) {
                            if (alreadyVisited4.contains(city5)) continue;
                            List<Integer> alreadyVisited5 = new ArrayList<>(alreadyVisited4);
                            alreadyVisited5.add(city5);

                            for (int city6 = 0; city6 < cities.size(); city6++) {
                                if (alreadyVisited5.contains(city6)) continue;
                                List<Integer> alreadyVisited6 = new ArrayList<>(alreadyVisited5);
                                alreadyVisited6.add(city6);

                                for (int city7 = 0; city7 < cities.size(); city7++) {
                                    if (alreadyVisited6.contains(city7)) continue;
                                    List<Integer> alreadyVisited7 = new ArrayList<>(alreadyVisited6);
                                    alreadyVisited7.add(city7);

                                    for (int city8 = 0; city8 < cities.size(); city8++) {
                                        if (alreadyVisited7.contains(city8)) continue;
                                        List<Integer> alreadyVisited8 = new ArrayList<>(alreadyVisited7);
                                        alreadyVisited8.add(city8);

                                        System.out.println(alreadyVisited8);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

//        for (int city1 = 0; city1 < cities.size(); city1++) {
//            System.out.println("Start from city " + names[city1]);
//            for (int city2 = 0; city2 < cities.size(); city2++) {
//
//            }
//            System.out.println();
//        }

        return 0;
    }

    private static int pickCity(int citiesCount, List<Integer> visited) {
        int index = 0;

        while (visited.contains(index) && index < citiesCount) index++;

        if (index == citiesCount)
            return -1;
        else
            return index;
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
