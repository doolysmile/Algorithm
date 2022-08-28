package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int ans = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N ; i++){
            for(int j = 0; j < M ; j++){
                // 세로 일자
                if(i + 3 < N){
                    ans = Math.max(ans, map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i+3][j]);
                }
                // 가로 일자
                if(j + 3 < M){
                    ans = Math.max(ans, map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j + 3]);
                }
                // 사각형
                if(i + 1 < N && j + 1 < M){
                    ans = Math.max(ans, map[i][j] + map[i + 1][j] + map[i][j + 1] + map[i + 1][j + 1]);
                }
                // 2 X 3
                if(i + 1 < N && j + 2 < M){
                    int tmp = map[i][j] + map[i][j + 1] + map[i][j + 2]
                            + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
                    ans = Math.max(ans, tmp - map[i][j] - map[i][j + 1]);
                    ans = Math.max(ans, tmp - map[i][j] - map[i][j + 2]);
                    ans = Math.max(ans, tmp - map[i][j] - map[i + 1][j + 2]);
                    ans = Math.max(ans, tmp - map[i][j + 1] - map[i][j + 2]);
                    ans = Math.max(ans, tmp - map[i][j + 2] - map[i + 1][j]);
                    ans = Math.max(ans, tmp - map[i + 1][j] - map[i + 1][j + 1]);
                    ans = Math.max(ans, tmp - map[i + 1][j] - map[i + 1][j + 2]);
                    ans = Math.max(ans, tmp - map[i + 1][j + 1] - map[i + 1][j + 2]);
                }
                // 3 X 2
                if(i + 2 < N && j + 1 < M){
                    int tmp = map[i][j] + map[i][j + 1]
                            + map[i + 1][j] + map[i + 1][j + 1]
                            + map[i + 2][j] + map[i + 2][j + 1];
                    ans = Math.max(ans, tmp - map[i][j] - map[i + 1][j]);
                    ans = Math.max(ans, tmp - map[i][j] - map[i + 2][j]);
                    ans = Math.max(ans, tmp - map[i][j] - map[i + 2][j + 1]);
                    ans = Math.max(ans, tmp - map[i][j + 1] - map[i + 1][j + 1]);
                    ans = Math.max(ans, tmp - map[i][j + 1] - map[i + 2][j]);
                    ans = Math.max(ans, tmp - map[i][j + 1] - map[i + 2][j + 1]);
                    ans = Math.max(ans, tmp - map[i + 1][j] - map[i + 2][j]);
                    ans = Math.max(ans, tmp - map[i + 1][j + 1] - map[i + 2][j + 1]);
                }
            }
        }
        System.out.println(ans);
    }
}
