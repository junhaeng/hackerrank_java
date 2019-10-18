package day8;
//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution{

    private static final String NOT_FOUND = "Not found";

    public static void main(String []argh){
        Map<String, Integer> phoneBook = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            phoneBook.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
            if (phoneBook.containsKey(s)) {
                System.out.printf("%s=%d\n", s, phoneBook.get(s));
            } else {
                System.out.println(NOT_FOUND);
            }
        }
        in.close();
    }
}

