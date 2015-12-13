package x0961h.adventofcode.day11;

import java.io.IOException;

/**
 * Created by 0x0961h on 13.12.2015.
 */
public class DaySolverAdvanced {
    public static void main(String[] args) throws IOException {
        System.out.println("Result = " + solve(solve("cqjxjnds")));
    }

    public static String solve(String input) {
        String newPass = input;

        do {
            newPass = increment(newPass);
        } while (!validate(newPass));

        return newPass;
    }

    static boolean validate(String input) {
        input = input.trim();
        if (input.length() != 8) return false;

        if (input.contains("i")) return false;
        if (input.contains("o")) return false;
        if (input.contains("l")) return false;

        boolean ruleSequence = false;
        boolean rulePair = false;
        char pair1 = 0;

        for (int i = 0; i < input.length() - 3; i++) {
            char c1 = input.charAt(i);
            char c2 = input.charAt(i + 1);
            char c3 = input.charAt(i + 2);

            if ((c2 - c1 == 1) && (c3 - c2 == 1)) ruleSequence = true;
        }

        for (int i = 0; i < input.length() - 1; i++) {
            char c1 = input.charAt(i);
            char c2 = input.charAt(i + 1);

            if (c1 == c2) {
                if (pair1 == 0) {
                    pair1 = c1;
                } else {
                    if (pair1 != c1) {
                        rulePair = true;
                    }
                }
            }
        }

        return ruleSequence && rulePair;
    }

    static String increment(String input) {
        StringBuilder sb = new StringBuilder(input);

        int index = input.length() - 1;

        while (index >= 0) {
            sb.setCharAt(index, (char)(sb.charAt(index) + 1));

            if (sb.charAt(index) > 'z') {
                sb.setCharAt(index, 'a');
                index--;
            } else {
                if (sb.charAt(index) != 'i' && sb.charAt(index) != 'o' && sb.charAt(index) != 'l') {
                    break;
                }
            }
        }

        return sb.toString();
    }
}
