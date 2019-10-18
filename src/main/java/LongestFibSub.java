import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LongestFibSub {
    static public int lenLongestFibSubseq(int[] A) {
        Set<Integer> s = new HashSet();
        for (int a : A) {
            s.add(a);
        }

        int start=0, end=1;
        int result = 2;
        while (end < A.length-1) {
            int sub_len = 2;
            int first = A[start];
            int second = A[end];
            boolean exist = s.contains(first + second);
            while (exist) {
                sub_len++;
                int temp = first;
                first = second;
                second = temp + second;
                exist = s.contains(first + second);
            }
            if (sub_len > 2) {
                result = Math.max(result, sub_len);
            }
            end++;
            if (end == A.length-1) {
                start++;
                end = start+1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(LongestFibSub.lenLongestFibSubseq(new int[]{
                1,3,7,11,12,14,18
        }));
    }
}
