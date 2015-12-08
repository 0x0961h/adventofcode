package x0961h.adventofcode.day08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by 0x0961h on 08.12.2015.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources", "day08.data")));
        System.out.println("Result = " + solve(input));
    }

    public static long solve(String input) {
        return Arrays.stream(input.split("\n")).
                map(line -> codeLength(line) - stringLength(line)).
                collect(Collectors.summarizingInt(value -> value)).
                getSum();
    }

    public static int codeLength(String s) {
        return s.length();
    }

    public static int stringLength(String s) {
        s = s.substring(1, s.length() - 1);
        return unescape(s).length();
    }

    public static String unescape(String s) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            switch (ch) {
                case '\\': {
                    if (i < s.length() - 1 && s.charAt(i + 1) == '\\') {
                        sb.append('\\');
                        i++;
                    } else if (i < s.length() - 1 && s.charAt(i + 1) == '"') {
                        sb.append('"');
                        i++;
                    } else if (i < s.length() - 3) {
                        if (s.charAt(i + 1) == 'x') {
                            if (Character.isDigit(s.charAt(i + 2)) || ('a' <= s.charAt(i + 2) && s.charAt(i + 2) <= 'f')) {
                                if (Character.isDigit(s.charAt(i + 3)) || ('a' <= s.charAt(i + 3) && s.charAt(i + 3) <= 'f')) {
                                    sb.append('@');
                                }
                            }
                        }

                        i += 3;
                    }
                    break;
                }

                default: sb.append(s.charAt(i));
            }

            i++;
        }

        return sb.toString();
    }
}
