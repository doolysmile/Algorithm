package git.Algorithm.baekjoon;

import java.util.*;

public class B11053 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] num = new int[size];
        int[] dp = new int[size];
        int ans = 0;
        for(int i = 0 ; i < size; i++) {
            num[i] = sc.nextInt();
        }
        for(int i = 1; i< size; i++) {
            for(int j = 0 ; j < i; j++) {
                if(num[i] > num[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.print(ans + 1 );
    }
}
