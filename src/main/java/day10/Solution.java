package day10;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int max_count=0;
        int count=0;
        while (n > 0){
            if ((n & 1) == 1) {
                count++;
            } else {
                max_count = Math.max(count, max_count);
                count=0;
            }
            n = n >> 1;
        }
        max_count = Math.max(count, max_count);
        System.out.println(max_count);
        scanner.close();
    }
}
