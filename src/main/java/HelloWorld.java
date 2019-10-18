import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HelloWorld {
    public static long aVeryBigSum(long[] ar) {
        long sum = 0;
        for (long l : ar) {
            sum += l;
        }
        return sum;

    }

        public static void main(String[] args) {
            long[] larr = new long[]{
                    10000000000l,10000000000l,10000000000l,10000000000l,10000000000l,10000000000l,10000000000l,10000000000l,10000000000l,10000000000l
            };
            System.out.println(aVeryBigSum(larr));
        }

}
