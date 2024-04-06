package org.example.hackerrank.array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> res = new ArrayList<>();
        int[] rank = new int[ranked.size()];
        Arrays.fill(rank, 1);
        for(int j = 1; j< ranked.size(); j++) {
            if(ranked.get(j-1) == ranked.get(j)) {
                rank[j] = rank[j-1];
            } else {
                rank[j] = rank[j-1] + 1;
            }
        }


        for(int i = 0, j = ranked.size()-1; i < player.size(); i++) {
            while(j>-1) {
                if(player.get(i) >= ranked.get(j)) {
                    j--;
                } else {
                    break;
                }
            }
            if(j == -1) {
                res.add(1);
            } else {
                res.add(rank[j] + 1);
            }


        }
        //player.stream().collect(toMap());
        return res;
    }

}

public class ClimbingLeaderboard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
