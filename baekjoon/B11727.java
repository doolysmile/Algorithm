package git.Algorithm.baekjoon;

import java.util.Scanner;

public class B11727 {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= N; i++)
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;

        System.out.println(dp[N]);
    }
}
