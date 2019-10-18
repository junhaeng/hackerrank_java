package samandsubstring;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the substrings function below.
    static int substrings(String n) {
        long[] sub_sum_arr  = new long[n.length()];

        sub_sum_arr[0] = n.charAt(0) - '0';

        for (int i=1; i<n.length(); i++) {
            sub_sum_arr[i] = (10*sub_sum_arr[i-1] + i*(n.charAt(i)-'0') + (n.charAt(i)-'0'))%1000000007;
        }

        long sum = 0;
        for (long r : sub_sum_arr) {
            sum += r;
            sum %= 1000000007;
        }
        return (int)(sum%1000000007);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String n = scanner.nextLine();

        int result = substrings(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


