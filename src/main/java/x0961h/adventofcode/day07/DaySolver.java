package x0961h.adventofcode.day07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 0x0961h on 07.12.2015.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources", "day07.data")));

        Map<String, Integer> solution = solve(input);

        List<String> coll = new ArrayList<>(solution.keySet());
        Collections.sort(coll);
        System.out.println(coll);
//        System.out.println("Result = " + solution);
    }

    public static Map<String, Integer> solve(String input) {
        Map<String, Integer> result = new HashMap<>();

        Arrays.
                stream(input.split("\n")).
                forEach(cmd -> solveCommand(cmd, result));

        return result;
    }

    private static void solveCommand(String cmd, Map<String, Integer> result) {
        if (cmd.startsWith("NOT ")) {
            // Complement
            String[] data = cmd.substring("NOT ".length()).split("\\s*->\\s*");
            String wireId = data[0];
            String resultWireId = data[1];
            if (!result.containsKey(wireId)) result.put(wireId, 0);
            int wireData = result.get(wireId);
            result.put(resultWireId, wireData ^ ((Integer.valueOf("111111111111111", 2) << 1) + 1));
        } else {
            String[] data = cmd.split("\\s*->\\s*");

            String resultWireId = data[1];

            if (data[0].matches("\\d+")) {
                // Provide signal to wire
                result.put(resultWireId, Integer.parseInt(data[0]));
            } else if (data[0].matches("([a-z]+|\\d+) (AND|OR) ([a-z]+)")) {
                Matcher mat = Pattern.compile("([a-z]+|\\d+) (AND|OR) ([a-z]+)").matcher(data[0]);
                mat.find();

                int wire1Data;
                if (mat.group(1).matches("\\d+")) {
                    wire1Data = Integer.parseInt(mat.group(1));
                } else {
                    String wire1ID = mat.group(1);
                    if (!result.containsKey(wire1ID)) result.put(wire1ID, 0);
                    wire1Data = result.get(wire1ID);
                }

                String wire2ID = mat.group(3);
                if (!result.containsKey(wire2ID)) result.put(wire2ID, 0);

                int wire2Data = result.get(wire2ID);
                int wireRes = 0;

                String bitwiseCommand = mat.group(2);

                switch (bitwiseCommand) {
                    case "AND": wireRes = (short) (wire1Data & wire2Data); break;
                    case "OR":  wireRes = (short) (wire1Data | wire2Data); break;
                }

                result.put(resultWireId, wireRes);
            } else if (data[0].matches("([a-z]+) (LSHIFT|RSHIFT) (\\d+)")) {
                Matcher mat = Pattern.compile("([a-z]+) (LSHIFT|RSHIFT) (\\d+)").matcher(data[0]);
                mat.find();
                String wire1ID = mat.group(1);
                if (!result.containsKey(wire1ID)) result.put(wire1ID, 0);
                int wire1Data = result.get(wire1ID);
                int shiftAmount = Short.parseShort(mat.group(3));
                int wireRes = 0;

                String bitwiseCommand = mat.group(2);

                switch (bitwiseCommand) {
                    case "LSHIFT":  wireRes = (short) (wire1Data << shiftAmount); break;
                    case "RSHIFT":  wireRes = (short) (wire1Data >> shiftAmount); break;
                }

                result.put(resultWireId, wireRes);
            }
        }
    }
}
