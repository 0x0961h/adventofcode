package x0961h.adventofcode.day12;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 0x0961h on 13.12.2015.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources", "day12.data")));
        System.out.println("Result = " + solve(input));
    }

    public static int solve(String input) {
        input = input.replaceAll("\\s+","").replaceAll("\"[^\"]+\"","");

        Pattern pat = Pattern.compile("-?\\d+");
        Matcher mat = pat.matcher(input);

        int sum = 0;
        while (mat.find()) {
            sum += Integer.valueOf(mat.group());
        }

        return sum;
    }
}
