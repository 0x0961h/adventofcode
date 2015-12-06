package x0961h.adventofcode.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by 0x0961h on 06.12.2015.
 */
public class DayLauncher {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources", "day01.data")));
        System.out.println("Result = " + getFinalFloorForInput(input));
    }

    public static int getFinalFloorForInput(String input) {
        int currentFloor = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') currentFloor++;
            else if (input.charAt(i) == ')') currentFloor--;
        }

        return currentFloor;
    }
}
