package interviewkit.string.anagram;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static class MutableInteger {
        private int value;

        public MutableInteger(int value) {
            this.value = value;
        }

        public void increase() {
            ++value;
        }
        public void decrease() {
            --value;
        }

        public int getValue() {
            return value;
        }

    }
    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        Map<Character, MutableInteger> countingMap = new HashMap<>();

        for (char c : a.toCharArray()) {
            MutableInteger count = countingMap.get(c);
            if (count == null) {
                countingMap.put(c, new MutableInteger(1));
            } else {
                count.increase();
            }
        }
        for (char c : b.toCharArray()) {
            MutableInteger count = countingMap.get(c);
            if (count == null) {
                countingMap.put(c, new MutableInteger(-1));
            } else {
                count.decrease();
            }
        }
        return countingMap.values().stream().map(MutableInteger::getValue).reduce((x,y) -> Math.abs(x) + Math.abs(y)).orElse(0);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
