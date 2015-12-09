package x0961h.adventofcode.day09;

import org.junit.Test;

/**
 * Created by 0x0961h on 07.12.2015.
 */
public class DaySolverTest {
    @Test
    public void test() {
        String[] cities = { "London", "Dublin", "Belfast" };
        int[][] distances = new int[cities.length][cities.length];
        distances[0][1] = 464;
        distances[1][0] = 464;
        distances[0][2] = 518;
        distances[2][0] = 518;
        distances[1][2] = 141;
        distances[2][1] = 141;

        DaySolver.solve(cities, distances);
    }

    @Test
    public void graphTest() {
        String[] cities = { "0", "1", "2", "3", "4", "5", "6", "7", "8" };
        int[][] distances = new int[cities.length][cities.length];

        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < cities.length; j++) {
                distances[i][j] = -1;
            }
        }

        distances[0][1] = 4;
        distances[0][7] = 8;
        distances[1][7] = 11;
        distances[1][2] = 8;
        distances[2][8] = 2;
        distances[2][5] = 4;
        distances[2][3] = 7;
        distances[3][4] = 9;
        distances[3][5] = 14;
        distances[4][5] = 10;
        distances[5][6] = 2;
        distances[6][7] = 1;
        distances[7][8] = 7;

        distances[1][0] = 4;
        distances[7][0] = 8;
        distances[7][1] = 11;
        distances[2][1] = 8;
        distances[8][2] = 2;
        distances[5][2] = 4;
        distances[3][2] = 7;
        distances[4][3] = 9;
        distances[5][3] = 14;
        distances[5][4] = 10;
        distances[6][5] = 2;
        distances[7][6] = 1;
        distances[8][7] = 7;

        DaySolver.solve(cities, distances);
    }
}
