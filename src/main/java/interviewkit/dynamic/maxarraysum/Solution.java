package interviewkit.dynamic.maxarraysum;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int[] subResult = new int[arr.length];
        for (int i=0; i<subResult.length; i++) {
            if (i-2 >= 0) {
                subResult[i] = Math.max(subResult[i-2] + arr[i], subResult[i-1]);
            } else if (i-1 >= 0) {
                subResult[i] = Math.max(subResult[i-1], arr[i]);
            } else {
                subResult[i] = Math.max(0, arr[i]);
            }
        }
        return subResult[subResult.length-1];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
        System.out.println(res);
    }
}
