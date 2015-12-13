package x0961h.adventofcode.day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by 0x0961h on 13.12.2015.
 */
public class DaySolverAdvanced {
    // 59607 -- low
    // 156051 -- high

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources", "day12.data")));
        System.out.println("Result = " + solve(input));
    }

    public static int solve(String input) {
        System.out.println(input);
        input = input.replaceAll("\\s+", "").replaceAll("\"red\"", "QQQ").replaceAll("\"[^\"]+\"", "");

        int i = input.indexOf("QQQ");
        int nesting = 0;

        lol: while (i != -1) {
            int start = i;
            int end = i + 3;

            while (start > 0 && input.charAt(start) != '{') {
                if (input.charAt(start) == '[') {
                    input = input.replaceFirst("QQQ", "aaa");
                    i = input.indexOf("QQQ");
                    continue lol;
                }
                start--;
            }

            while (end < input.length() - 1 && input.charAt(end) != '}') {
                end++;

                if (input.charAt(end) == '{') {
                    nesting++;
                }

                while (input.charAt(end) == '}' && nesting > 0) {
                    end++;
                    nesting--;
                }
            }

            end++;

            if (input.charAt(start) == '[' && input.charAt(end - 1) == ']') {
                input = input.replaceFirst("QQQ", "aaa");
            } else {
                String s = input.substring(start, end);
                s = s.replaceAll("([{}\\[\\]])", "\\\\$1");
                System.out.println(s);
                input = input.replaceFirst(s, "~~~");
            }

            i = input.indexOf("QQQ");
        }

        System.out.println(input);
        return DaySolver.solve(input);
    }
}
