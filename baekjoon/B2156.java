package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] wine = new int[N];
        int[][] dp = new int[N][2];
        for(int i = 0; i < N; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }
        dp[0][0] = wine[0];
        dp[0][1] = 0;
        for(int i = 1; i < N; i++){
            if(i == 1){
                dp[i][0] = dp[i - 1][0] + wine[i];
                dp[i][1] = wine[i - 1];
            }
            else if( i == 2){
                dp[i][0] = Math.max(dp[i-2][0] + wine[i], dp[i-2][1] + wine[i] + wine[i-1]);
                dp[i][1] = dp[i-1][0];
            }
            else{
                // oxoo, xo, xxoo
                dp[i][0] = Math.max(Math.max(dp[i-2][1] + wine[i-1] + wine[i], dp[i-1][1] + wine[i]), dp[i-3][1] + wine[i -1] + wine[i]);
                // xoox, oxox, oxx
                dp[i][1] = Math.max(Math.max(dp[i-3][1] + wine[i-2] + wine[i-1], dp[i-2][1] + wine[i-1]), dp[i-2][0]);

            }
        }
        System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));
//        for(int i = 0; i < N; i++){
//            System.out.println(i + " " +  dp[i][0] + " " + dp[i][1]);
//        }
    }


}