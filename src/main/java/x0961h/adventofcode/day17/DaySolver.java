package x0961h.adventofcode.day17;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 0x0961h on 13.12.2015.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources", "day17.data")));
        System.out.println("Result = " + solve(input, 150));
    }

    public static int solve(String input, int liters) {
        List<Integer> containers = new ArrayList<>();

        final List<Integer> finalContainers = containers;
        Arrays.stream(input.split("\n")).
                forEach(line -> finalContainers.add(Integer.parseInt(line.trim())));

//        for (int j = 0; j < containers.size(); j++) {
            for (int i = 0; i < containers.size() - 1; i++) {
            for (int j = 0; i < containers.size() - 1; i++) {
                iteration(liters, containers);
                containers = shiftLeft(containers, 1, containers.size() - 1);
                System.out.println(containers);
            }
            }
//        }

        return 0;
    }

    private static void iteration(int liters, List<Integer> containers) {
        int litersLeft = liters;
        List<Integer> containersLeft = new ArrayList<>(containers);
        while (litersLeft > 0 && !containersLeft.isEmpty()) {
            int containerPicked = containersLeft.get(0);
            if (litersLeft - containerPicked >= 0) {
                litersLeft -= containerPicked;
                System.out.println(containerPicked);
            }
            containersLeft.remove(0);
        }
    }

    public static List<Integer> shiftLeft(List<Integer> oldList) {
        return shiftLeft(oldList, 0, oldList.size() - 1);
    }

    public static List<Integer> shiftLeft(List<Integer> oldList, int fromIndex, int toIndex) {
        List<Integer> newList = new ArrayList<>(oldList);

        int shifted = newList.get(fromIndex);
        for (int i = fromIndex; i <= toIndex - 1; i++) {
            newList.set(i, newList.get(i + 1));
        }
        newList.set(toIndex, shifted);

        return newList;
    }
}
