package x0961h.adventofcode.day19;


import info.debatty.java.stringsimilarity.NormalizedLevenshtein;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by 0x0961h on 13.12.2015.
 */
public class DaySolverAdvanced {
    private final static boolean debug = false;

    public static void main(String[] args) throws IOException {
        System.out.println("Result = " + solve(
                new String(Files.readAllBytes(Paths.get("src/main/resources", "day19.data"))),
                new String(Files.readAllBytes(Paths.get("src/main/resources", "day19.input")))
        ));
    }

    public static int solve(String replacementsRaw, String target) {
        Map<String, List<String>> replacements = Arrays.stream(replacementsRaw.split("\n")).
                map(line -> {
                    String[] spl = line.trim().split("\\s*=>\\s*");
                    return new AbstractMap.SimpleEntry<>(spl[0], spl[1]);
                }).
                collect(
                        Collectors.groupingBy(
                                AbstractMap.SimpleEntry::getKey,
                                Collectors.mapping(
                                        AbstractMap.SimpleEntry::getValue,
                                        Collectors.toList()
                                )
                        )
                );

        Pattern pat = Pattern.compile("(e|[A-Z][a-z]?)");
        String current = "e";

        iteration(target, replacements, pat, current);
        iteration(target, replacements, pat, current);

//        System.out.println(current);

        return 0;
    }

    private static void iteration(String target, Map<String, List<String>> replacements, Pattern pat, String current) {
        Matcher mat = pat.matcher(current);

        while (mat.find()) {
            String prefix = current.substring(0, mat.start());
            String postfix = current.substring(mat.end());

            if (replacements.containsKey(mat.group())) {
                replacements.get(mat.group()).stream().
                        map(repl -> prefix + repl + postfix).
                        forEach(s -> {
                            NormalizedLevenshtein l = new NormalizedLevenshtein();
                            System.out.println(s + " | " + target + " = " + l.distance(s, target));
                        });
            }
            System.out.println();
        }
    }
}
