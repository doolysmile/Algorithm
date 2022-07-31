package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[][] dp = new long[2][21];
        dp[0][input[0]] = 1L;
        int q1 = 0;
        int q2 = 1;
        for(int i = 1; i < N - 1; i++){         // input
            for(int j = 0; j <= 20; j++){   // dp 크기
                if(dp[q1][j] != 0){
                    if(0 <= j + input[i] && j + input[i] <= 20){
                        dp[q2][j + input[i]] += dp[q1][j];
                    }
                    if(0 <= j - input[i] && j - input[i] <= 20){
                        dp[q2][j - input[i]] += dp[q1][j];
                    }
                }
            }
            Arrays.fill(dp[q1], 0);
            q1 = q1 == 0 ? 1 : 0;
            q2 = q2 == 0 ? 1 : 0;
        }
        System.out.println(dp[q1][input[N - 1]]);
    }
}
