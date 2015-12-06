package x0961h.adventofcode.day04;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 0x0961h on 06.12.2015.
 */
public class DaySolver {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("Result = " + solve("bgvyzdsv"));
    }

    public static int solve(String input) throws NoSuchAlgorithmException {
        int tail = 0;
        String testInput;
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digest;
        String hash;

        do {
            testInput = input + tail;

            md5.update(testInput.getBytes());
            digest = md5.digest();

            BigInteger bi = new BigInteger(1, digest);
            hash = bi.toString(16);
            while (hash.length() < 32) hash = "0" + hash;

            tail++;
        } while (!hash.startsWith("00000"));

        return tail - 1;
    }
}
