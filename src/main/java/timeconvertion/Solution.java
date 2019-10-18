package timeconvertion;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        if (s.contains("PM")) {
            int hour = Integer.parseInt(s.substring(0,2));
            String hourString = (hour + 12) + "";
            if (hour == 12) {
                hourString = hour + "";
            }
            return hourString + s.substring(2, s.length()-2);
        } else {
            int hour = Integer.parseInt(s.substring(0,2))%12;
            return (hour < 10 ? "0" + hour : hour) + s.substring(2, s.length()-2);
        }

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
