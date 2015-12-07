package x0961h.adventofcode.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by 0x0961h on 07.12.2015.
 */
public class DaySolverAdvanced {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources", "day01.data")));
        System.out.println("Result = " + solve(input));
    }

    public static int solve(String input) {
        int currentFloor = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') currentFloor++;
            else if (input.charAt(i) == ')') currentFloor--;

            if (currentFloor < 0) return i + 1;
        }

        return currentFloor;
    }
}
