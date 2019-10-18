package kakao.problem3;

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



class Result {

    /*
     * Complete the 'compressWord' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING word
     *  2. INTEGER K
     */

    public static String compressWord(String word, int K) {
        // Write your code here
        String result = word;
        while (result.length() > K) {
            StringBuffer buffer = new StringBuffer();
            char before = '#';
            int cnt=0;
            char[] cArr = result.toCharArray();
            for (char c : cArr) {
                if (c != before) {
                    if (before != '#') {
                        for (int i=0; i<cnt; i++){
                            buffer.append(before);
                        }
                    }
                    before = c;
                    cnt = 1;
                } else {
                    cnt++;
                }

                if (cnt == K) {
                    before = '#';
                    cnt = 0;
                }
            }
            if (before != '#') {
                for (int i=0; i<cnt; i++) {
                    buffer.append(before);
                }
            }
            String newResult = buffer.toString();
            if (newResult.length() == result.length()) {
                return newResult;
            }
            result = newResult;
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String word = bufferedReader.readLine();

        int K = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.compressWord(word, K);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
        System.out.println(result);
    }
}