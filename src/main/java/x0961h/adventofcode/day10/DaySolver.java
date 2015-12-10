package x0961h.adventofcode.day10;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 0x0961h on 10.12.2015.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        String input = "1321131112";

        for (int i = 0; i < 40; i++) {
            input = solve(input);
        }

        System.out.println("Result = " + input);
        System.out.println("Length = " + input.length());
    }

    public static String solve(String input) {
        List<Map.Entry<Character, Integer>> sequence = new ArrayList<>();
        char lastChar = input.charAt(0);
        sequence.add(new AbstractMap.SimpleEntry<>(lastChar, 1));

        for (int i = 1; i < input.length(); i++) {
            char newChar = input.charAt(i);
            if (newChar == lastChar) {
                sequence.get(sequence.size() - 1).setValue(sequence.get(sequence.size() - 1).getValue() + 1);
            } else {
                lastChar = newChar;
                sequence.add(new AbstractMap.SimpleEntry<>(lastChar, 1));
            }
        }

        return sequenceToString(sequence);
    }

    private static String sequenceToString(List<Map.Entry<Character, Integer>> sequence) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : sequence) {
            sb.append(entry.getValue()).append(entry.getKey());
        }

        return sb.toString();
    }
}
