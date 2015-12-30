package x0961h.adventofcode.day12;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by 0x0961h on 13.12.2015.
 */
public class DaySolverAdvanced {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources", "day12.data")));
        System.out.println("Result = " + solve(input));
    }

    public static long solve(String input) {
        Long sum = 0L;
        Object dataRaw = JSONValue.parse(input);

        sum += parseIteration(dataRaw);

        return sum;
    }

    private static long parseIteration(Object dataRaw) {
        Long tempSum = 0L;
        if (dataRaw instanceof JSONArray) {
            JSONArray data = (JSONArray) dataRaw;
            for (Object o : data) {
                if (o instanceof Long) {
                    tempSum += (Long) o;
                } else if (o instanceof JSONObject) {
                    tempSum += parseIteration(o);
                } else if (o instanceof JSONArray) {
                    tempSum += parseIteration(o);
                }
            }
        } else {
            JSONObject data = (JSONObject) dataRaw;
            for (Object o : data.values()) {
                if (o instanceof Long) {
                    tempSum += (Long) o;
                } else if (o instanceof JSONObject) {
                    tempSum += parseIteration(o);
                } else if (o instanceof JSONArray) {
                    tempSum += parseIteration(o);
                } else if (o instanceof String) {
                    if (o.equals("red")) return 0;
                } else {
                    System.out.println(o.getClass());
                }
            }
        }

        return tempSum;
    }
}
