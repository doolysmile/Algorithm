package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(N != 1){
            int x = 0;
            int y = 0;
            for(int i = 0; i < N; i = i + 2){
                for(int j = 0; j < N; j= j + 2){
                    int[] temp = {map[i][j], map[i + 1][j], map[i][j + 1], map[i + 1][j + 1]};
                    Arrays.sort(temp);
                    map[x][y] = temp[2];
                    y++;
                }
                y = 0;
                x++;
            }
            N = N/2;
        }
        System.out.println(map[0][0]);
    }
}
