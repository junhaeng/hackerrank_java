package interviewkit.graph.roadsandlibrary;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// 히든케이스에서 털
public class Solution {

    // Complete the roadsAndLibraries function below.
//    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
//        if (c_road > c_lib) {
//            return c_lib * n;
//        }
//
//        boolean[] visit = new boolean[n+1];
//        boolean[][] adjMatrix = new boolean[n+1][n+1]; //from, to
//        for (int[] road : cities) {
//            adjMatrix[road[0]][road[1]] = true;
//            adjMatrix[road[1]][road[0]] = true;
//        }
//
//        int cost = 0;
//        for (int i=1; i<visit.length; i++) {
//            if (visit[i]) {
//                continue;
//            }
//            int visitCount = 0;
//            Deque<Integer> queue = new ArrayDeque();
//            queue.addLast(i);
//            while (!queue.isEmpty()) {
//                int city = queue.pollFirst();
//                if (visit[city] == false) {
//                    visit[city] = true;
//                    visitCount++;
//                    for (int j=0; j<adjMatrix[city].length; j++) {
//                        if(adjMatrix[city][j] && !visit[j]) {
//                            queue.addLast(j);
//                        }
//                    }
//                }
//            }
//            cost += (visitCount-1)*c_road + c_lib;
//        }
//
//        return cost;
//    }

    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        if (c_road > c_lib) {
            return (long)c_lib * (long)n;
        }

        boolean[] visit = new boolean[n + 1];
        long groupCount = 0;
        Set[] groupArrary = new Set[n + 1];

        for (int[] city : cities) {
            if (!visit[city[0]] && !visit[city[1]]) {
                visit[city[0]] = true;
                visit[city[1]] = true;
                groupCount++;
                Set<Integer> cityGroup = new HashSet<>();
                cityGroup.add(city[0]);
                cityGroup.add(city[1]);
                groupArrary[city[0]] = cityGroup;
                groupArrary[city[1]] = cityGroup;
            } else if (!visit[city[0]]) {
                visit[city[0]] = true;
                groupArrary[city[1]].add(city[0]);
                groupArrary[city[0]] = groupArrary[city[1]];
            } else if (!visit[city[1]]) {
                visit[city[1]] = true;
                groupArrary[city[0]].add(city[1]);
                groupArrary[city[1]] = groupArrary[city[0]];
            } else {
                if (!groupArrary[city[0]].contains(city[1]) && !groupArrary[city[1]].contains(city[0])) {
                    groupCount--;
                    groupArrary[city[0]].addAll(groupArrary[city[1]]);
                    groupArrary[city[1]].stream().forEach(c -> {
                        groupArrary[(Integer)c] = groupArrary[city[0]];
                    });
                }
            }
        }

        long cost = 0;
        long unvisitCityCount = 0;
        for (int i = 1; i < visit.length; i++) {
            if (!visit[i]) {
                cost += c_lib;
                unvisitCityCount++;
            }
        }
        long totalConnectedCityCount = n - unvisitCityCount;
        if (groupCount > 0)
            return groupCount * c_lib + (totalConnectedCityCount - 1 - (groupCount - 1)) * c_road + cost;
        else
            return cost;
    }

//    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));


        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/heojunhaeng/Documents/workspace/app-repo/hackerrank/src/main/java/interviewkit/graph/roadsandlibrary/input03.txt"));
//        int q = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int q = Integer.parseInt(bufferedReader.readLine());

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = bufferedReader.readLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = bufferedReader.readLine().split(" ");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
            System.out.println(result);
        }

//        bufferedWriter.close();

//        scanner.close();
//        bufferedReader.close();
    }
}

