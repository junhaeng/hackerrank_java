package kakao.problem2;

import javax.swing.*;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Counter {
    private int value;
    public Counter(int initValue) {
        this.value = initValue;
    }
    public void increase() {
        value++;
    }
    public void decrease() {
        value--;
    }
    public int getValue() {
        return value;
    }
}

class Result {

    /*
     * Complete the 'areAlmostEquivalent' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY s
     *  2. STRING_ARRAY t
     */

    public static List<String> areAlmostEquivalent(List<String> s, List<String> t) {
        // Write your code here
        List<String> result = new ArrayList<>();
        for (int i=0; i<s.size(); i++) {
            if (s.get(i).length() != t.get(i).length()) {
                result.add("NO");
                continue;
            }
            Map<Character, Counter> countingMap = new HashMap<>();
            char[] sArr = s.get(i).toCharArray();
            char[] tArr = t.get(i).toCharArray();
            for (int j=0; j<sArr.length; j++) {
                Counter sCounter = countingMap.get(sArr[j]);
                if (sCounter == null) {
                    countingMap.put(sArr[j], new Counter(1));
                } else {
                    sCounter.increase();
                }

                Counter tCounter = countingMap.get(tArr[j]);
                if (tCounter == null) {
                    countingMap.put(tArr[j], new Counter(-1));
                } else {
                    tCounter.decrease();
                }
            }

            boolean find = false;
            for (Counter c : countingMap.values()) {
                if (Math.abs(c.getValue()) > 3) {
                    find = true;
                    result.add("NO");
                    break;
                }
            }
            if (!find) {
                result.add("YES");
            }
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int sCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> s = IntStream.range(0, sCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int tCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> t = IntStream.range(0, tCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = Result.areAlmostEquivalent(s, t);

        System.out.println(result.stream()
                .collect(joining("\n")));
        /*bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );*/

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
