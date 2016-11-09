package x0961h.adventofcode.day13;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

//        System.out.println(people);
//        System.out.println(Arrays.deepToString(matr));

        List<Set<String>> sets = new ArrayList<>();
        for (int i0 = 0; i0 < 4; i0++) {
            for (int i1 = 0; i1 < 4; i1++) {
                for (int i2 = 0; i2 < 4; i2++) {
                    for (int i3 = 0; i3 < 4; i3++) {
                        HashSet<String> hs = new HashSet<>(Arrays.asList(
                                people.get(i0),
                                people.get(i1),
                                people.get(i2),
                                people.get(i3)
                        ));

                        if (hs.size() == 4) sets.add(hs);
                    }
                }
            }
        }

        System.out.println(sets);

        return -1;
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
