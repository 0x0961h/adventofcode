package x0961h.adventofcode.day07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by 0x0961h on 07.12.2015.
 */
public class DaySolver {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/main/resources", "day07.data")));
        Map<String, Integer> solution = solve(input);
        System.out.println("Result = " + solution.get("a"));
    }

    public static Map<String, Integer> solve(String input) {
        Map<String, Integer> result = new HashMap<>();
        Map<String, List<Runnable>> futures = new HashMap<>();

        Arrays.
                stream(input.split("\r?\n")).
                forEach(cmd -> solveCommand(cmd, result, futures));

        return result;
    }

    private static void solveCommand(String cmdLine, Map<String, Integer> result, Map<String, List<Runnable>> futures) {
        if (cmdLine.matches("\\w+ -> \\w+")) {
            String[] movData = cmdLine.split(" -> ");

            Integer i = null;
            if (movData[0].matches("\\d+")) {
                i = Integer.valueOf(movData[0]);
            } else {
                if (result.containsKey(movData[0])) {
                    i = result.get(movData[0]);
                } else {
                    future(futures, movData[0], () -> {
                        set(movData[1], result.get(movData[0]), result, futures);
                    });
                }
            }

            if (i != null) set(movData[1], i, result, futures);
        } else if (cmdLine.matches("NOT \\w+ -> \\w+")) {
            cmdLine = cmdLine.substring("NOT ".length());
            String[] negData = cmdLine.split(" -> ");

            Runnable action = () -> {
                Integer val;
                if (negData[0].matches("\\d+"))
                    val = Integer.valueOf(negData[0]);
                else
                    val = result.get(negData[0]);

                set(
                        negData[1],
                        val ^ ((Integer.valueOf("111111111111111", 2) << 1) + 1),
                        result,
                        futures
                );
            };

            if (result.containsKey(negData[0]))
                action.run();
            else
                future(futures, negData[0], action);
        } else {
            String[] logicData = cmdLine.split(" -> ");

            String target = logicData[1];
            String[] cmdData = logicData[0].split(" ");

            Runnable logicOp = () -> {
                Integer a1, a2, b = 0;
                if (cmdData[0].matches("\\d+")) a1 = Integer.valueOf(cmdData[0]); else a1 = result.get(cmdData[0]);
                if (cmdData[2].matches("\\d+")) a2 = Integer.valueOf(cmdData[2]); else a2 = result.get(cmdData[2]);

                switch (cmdData[1]) {
                    case "OR": b = a1 | a2; break;
                    case "AND": b = a1 & a2; break;
                    case "LSHIFT": b = a1 << a2; break;
                    case "RSHIFT": b = a1 >> a2; break;
                }

                set(target, b, result, futures);
            };

            if (!cmdData[0].matches("\\d+") && !result.containsKey(cmdData[0])) {
                future(futures, cmdData[0], () -> {
                    if (!cmdData[2].matches("\\d+") && !result.containsKey(cmdData[2])) return;
                    logicOp.run();
                });
            }

            if (!cmdData[2].matches("\\d+") && !result.containsKey(cmdData[2])) {
                future(futures, cmdData[2], () -> {
                    if (!cmdData[0].matches("\\d+") && !result.containsKey(cmdData[0])) return;
                    logicOp.run();
                });
            }

            if (result.containsKey(cmdData[0]) && result.containsKey(cmdData[2]) ||
                    result.containsKey(cmdData[0]) && cmdData[2].matches("\\d+") ||
                    result.containsKey(cmdData[2]) && cmdData[0].matches("\\d+")) {
                logicOp.run();
            }
        }
    }

    private static void future(Map<String, List<Runnable>> futures, String var, Runnable future) {
        if (!futures.containsKey(var)) futures.put(var, new ArrayList<>());
        futures.get(var).add(future);
    }

    private static void set(String variableName, Integer value, Map<String, Integer> result, Map<String, List<Runnable>> futures) {
        result.put(variableName, value);
        if (futures.containsKey(variableName)) {
            for (Runnable future : futures.get(variableName)) future.run();
            futures.remove(variableName);
        }
    }
}
