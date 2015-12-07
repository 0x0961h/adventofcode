package x0961h.adventofcode.day03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 0x0961h on 06.12.2015.
 */
public class DaySolverAdvanced {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources", "day03.data")));
        System.out.println("Result = " + solve(input));
    }

    private static class Coord {
        public int x, y;

        public Coord() {
            this.x = 0;
            this.y = 0;
        }

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Coord coord = (Coord) o;

            if (x != coord.x) return false;
            return y == coord.y;

        }

        public Coord cpy() {
            return new Coord(x, y);
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 15451 * result + y;
            return result;
        }
    }

    public static int solve(String input) {
        Coord lastCoordSanta = new Coord();
        Coord lastCoordRoboSanta = new Coord();
        Set<Coord> visited = new HashSet<>();
        visited.add(lastCoordSanta.cpy());
        visited.add(lastCoordRoboSanta.cpy());

        for (int i = 0; i < input.length(); i++) {
            char cmd = input.charAt(i);

            Coord activeCoord = i % 2 == 0 ? lastCoordSanta : lastCoordRoboSanta;

            switch (cmd) {
                case '^': activeCoord.y++; break;
                case '<': activeCoord.x--; break;
                case 'v': activeCoord.y--; break;
                case '>': activeCoord.x++; break;
            }

            if (!visited.contains(activeCoord)) {
                visited.add(activeCoord.cpy());
            }
        }

        return visited.size();
    }
}
