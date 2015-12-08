package x0961h.adventofcode.day08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by 0x0961h on 08.12.2015.
 */
public class DaySolverAdvanced {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources", "day08.data")));
        System.out.println("Result = " + solve(input));
    }

    public static long solve(String input) {
        return Arrays.stream(input.split("\n")).
                map(line -> escapedLength(line) - codeLength(line)).
                collect(Collectors.summarizingInt(value -> value)).
                getSum();
    }

    public static int codeLength(String s) {
        return s.length();
    }

    public static int escapedLength(String s) {
        return escape(s).length();
    }

    public static String escape(String s) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            switch (ch) {
                case '\\': {
                    sb.append("\\\\");
                    break;
                }
                case '\"': {
                    sb.append("\\\"");
                    break;
                }

                default: sb.append(s.charAt(i));
            }

            i++;
        }

        return "\"" + sb.toString() + "\"";
    }
}
