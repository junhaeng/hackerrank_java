package climbingtheleaderboard;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] rank = new int[scores.length];
        rank[0] = 1;
        for (int i=1; i<scores.length; i++) {
            if (scores[i-1] > scores[i]) {
                rank[i] = rank[i-1]+1;
            } else if (scores[i-1] == scores[i]) {
                rank[i] = rank[i-1];
            }
        }

        List<Integer> result = new ArrayList<>();
        int pos_a = scores.length-1;

        boolean got_first = false;
        for (int ac : alice) {
            if (got_first) {
                result.add(1);
                continue;
            }
            boolean find_pos = false;
            while (pos_a >= 0) {
                if (scores[pos_a] > ac) {
                    result.add(rank[pos_a] + 1);
                    find_pos = true;
                    break;
                } else if (scores[pos_a] == ac) {
                    result.add(rank[pos_a]);
                    find_pos = true;
                    break;
                }
                pos_a--;
            }
            if (!find_pos) {
                result.add(1);
                got_first = true;
            }

        }
        return result.stream().mapToInt(i->i).toArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
