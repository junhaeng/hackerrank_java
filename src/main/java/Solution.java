import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<String> slist = new ArrayList<>();
        for (int i=0 ; i<t; i++) {
            slist.add(scanner.nextLine());
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        }
        scanner.close();

        for (String s : slist) {
            StringBuffer left = new StringBuffer();
            StringBuffer right = new StringBuffer();
            for (int i = 0 ; i < s.length(); i++) {
                if (i%2 == 0) {
                    left.append(s.charAt(i));
                } else {
                    right.append(s.charAt(i));
                }
            }
            System.out.println(left + " "  + right);
        }

    }
}
