package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] goal = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] input = new int[goal[0] + 1];
        int[] dp = new int[goal[1] + 1];
        for(int i = 1; i <= goal[0]; i++){
            input[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;
        for(int i = 1; i <= goal[0]; i ++){
            for(int j = 1; j <= goal[1]; j++){
                if(j >= input[i]){
                    dp[j] = dp[j] + dp[j - input[i]];
                }
            }
        }
        System.out.println(dp[goal[1]]);
    }
}
