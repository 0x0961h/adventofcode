package x0961h.adventofcode.day19;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by 0x0961h on 13.12.2015.
 */
public class DaySolver {
    private final static boolean debug = false;

    public static void main(String[] args) throws IOException {
        System.out.println("Result = " + solve(
                new String(Files.readAllBytes(Paths.get("src/main/resources", "day19.data"))),
                new String(Files.readAllBytes(Paths.get("src/main/resources", "day19.input")))
        ));
    }

    public static int solve(String replacementsRaw, String input) {
        Map<String, List<String>> replacements = Arrays.stream(replacementsRaw.split("\n")).
                map(line -> {
                    String[] spl = line.trim().split("\\s*=>\\s*");
                    return new AbstractMap.SimpleEntry<>(spl[0], spl[1]);
                }).
                collect(Collectors.groupingBy(e -> e.getKey(), Collectors.mapping(e -> e.getValue(), Collectors.toList())));

        Set<String> results = new HashSet<>();

        Pattern pat = Pattern.compile("[A-Z][a-z]?");
        Matcher mat = pat.matcher(input);
        while (mat.find()) {
            if (debug) System.out.println(input.substring(0, mat.start()) + "(" + mat.group() + ")" + input.substring(mat.end()));

            String prefix = input.substring(0, mat.start());
            String postfix = input.substring(mat.end());

            if (replacements.containsKey(mat.group())) {
                results.addAll(
                        replacements.get(mat.group()).stream().
                                map(repl -> prefix + repl + postfix).
                                collect(Collectors.toList())
                );
            }
        }

        return results.size();
    }
}
