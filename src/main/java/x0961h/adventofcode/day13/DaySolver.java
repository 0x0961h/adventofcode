package x0961h.adventofcode.day13;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by 0x0961h on 13.12.2015.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
//        String input = new String(Files.readAllBytes(Paths.get("src/main/resources", "day12.data")));
//        System.out.println("Result = " + solve(input));
    }

    public static int solve(String input) {
        Map<Integer, String> people = new HashMap<>();
        int[][] matr = extractDataFromInput(input, people);

        List<Set<String>> sets = new ArrayList<>();
        Integer[] indices = new Integer[people.size()];
        for (int i = 0; i < indices.length; i++) indices[i] = 0;

        do {
            HashSet<String> hs = new HashSet<>(
                    Arrays.stream(indices).map(people::get).collect(Collectors.toList())
            );

            if (hs.size() == 4) sets.add(hs);
        } while (incrementIndex(indices));

//        for (Set<String> set : sets) {
//
//        }

        return -1;
    }

    private static boolean incrementIndex(Integer[] indices) {
        for (int i = indices.length - 1; i >= 0; i--) {
            indices[i]++;
            if (indices[i] < indices.length) return true;
            indices[i] = 0;
        }

        return false;
    }

    private static int[][] extractDataFromInput(String input, final Map<Integer, String> people) {
        Map<String, Integer> peopleLookup = new HashMap<>();
        Map<Map.Entry<String, String>, Integer> tempMatr = new HashMap<>();

        Pattern pat = Pattern.compile("(\\w+) would (\\w+) (\\d+) happiness units by sitting next to (\\w+).");

        Arrays.stream(input.split("\n")).
                forEach(line -> {
                    Matcher mat = pat.matcher(line);

                    if (mat.find()) {
                        String person1 = mat.group(1).toLowerCase();
                        String person2 = mat.group(4).toLowerCase();
                        boolean gain = mat.group(2).toLowerCase().equals("gain");
                        int amount = Integer.parseInt(mat.group(3));

                        if (!peopleLookup.containsKey(person1)) {
                            people.put(peopleLookup.size(), person1);
                            peopleLookup.put(person1, peopleLookup.size());
                        }

                        if (!peopleLookup.containsKey(person2)) {
                            people.put(peopleLookup.size(), person2);
                            peopleLookup.put(person2, peopleLookup.size());
                        }

                        if (!gain) amount *= -1;

                        tempMatr.put(new AbstractMap.SimpleEntry<>(person1, person2), amount);
                    }
                });

        int[][] matr = new int[peopleLookup.size()][peopleLookup.size()];
        for (Map.Entry<Map.Entry<String, String>, Integer> e : tempMatr.entrySet()) {
            int i1 = peopleLookup.get(e.getKey().getKey());
            int i2 = peopleLookup.get(e.getKey().getValue());
            matr[i1][i2] = e.getValue();
        }

        return matr;
    }
}
