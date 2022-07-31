package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] WV = new int[NK[0]][2];
        int[][] dp = new int[NK[0] + 1][NK[1] + 1];
        for(int i = 0; i < NK[0]; i++){
            WV[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for(int i = 1; i <= NK[0]; i++){
            for(int j = 1; j <= NK[1]; j++){
                if(j - WV[i - 1][0] >= 0){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - WV[i - 1][0]] + WV[i - 1][1]);
                }
                // j - WV[i - 1][0] < 0 일 때 dp[i][j] 값은 그 전 dp[i - 1][j]에서 받아오는 부분
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[NK[0]][NK[1]]);
    }
}
