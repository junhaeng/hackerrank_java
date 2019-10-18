package staircase;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the staircase function below.
    static void staircase(int n) {
        for (int i=1; i<=n; i++) {
            StringBuffer b = new StringBuffer();
            for (int j=0; j<n-i; j++) {
                b.append(" ");
            }
            for (int j=0; j<i; j++) {
                b.append("#");
            }
            System.out.println(b);
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
