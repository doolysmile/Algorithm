package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B22871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] dp = new long[N];

        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i < N; i++){
            for(int j = 0; j < i; j++){
                long K = Math.max((i - j) * (long)(1 + Math.abs(A[i] - A[j])), dp[j]);
                dp[i] = Math.min(dp[i], K);
            }
        }

        System.out.print(dp[N - 1]);
        // 1 4 1 3 1
        // 1 4 1
        // 1   1
    }
}
