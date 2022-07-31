package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B18427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][] block = new int[N][M];
        long[][] dp = new long[N + 1][H + 1];
        dp[0][0] = 1;
        for(int i = 0; i < N; i++){
            String[] tmp = br.readLine().split(" ");
            for(int j = 0; j < tmp.length; j++){
                block[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        for(int i = 0; i < N; i++){         // 학생번호
            for(int j = 0; j <= H; j++){    // DP
                dp[i+1][j] = (dp[i][j] + dp[i+1][j]) % 10007;
                if(dp[i][j] != 0){
                    for(int k = 0; k < M; k++){ //블럭번호
                        if(block[i][k] != 0 && j + block[i][k] <= H ){
                            dp[i + 1][j + block[i][k]] = (dp[i + 1][j + block[i][k]] + dp[i][j]) % 10007;
                        }
                    }
                }
            }

        }
        System.out.println(dp[N][H]);
    }
}
