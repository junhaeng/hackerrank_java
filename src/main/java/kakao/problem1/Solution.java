package kakao.problem1;

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
     * Complete the 'reduceCapacity' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY model as parameter.
     */

    // 일단 그리디 알고리즘으로
    public static int reduceCapacity(List<Integer> model) {
        // Write your code here
        Map<Integer, Counter> countMap = new HashMap<>();
        for (Integer i : model) {
            Counter count = countMap.get(i);
            if (count == null) {
                countMap.put(i, new Counter(1));
            } else {
                count.increase();
            }
        }

        List<Integer> modelCount = countMap.values().stream().map(Counter::getValue).sorted((a,b) -> -Integer.compare(a, b)).collect(toList());
        int targetCount = model.size() - (int) Math.ceil((double)model.size() / 2);
        int currentCount = model.size();

        int time = 0;
        for (int m : modelCount) {
            if (currentCount - m <= 0) {
                continue;
            }
            currentCount -= m;
            time++;
            if (currentCount <= targetCount) {
                return time;
            }
        }
        return time;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int modelCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> model = IntStream.range(0, modelCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.reduceCapacity(model);

        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

