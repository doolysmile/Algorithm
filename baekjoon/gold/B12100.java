package git.Algorithm.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12100 {
    static int N;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ans = Integer.MIN_VALUE;
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(map, 0);
        System.out.println(ans);
    }

    private static void dfs(int[][] map, int depth) {
        if(depth == 5){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    ans = Math.max(ans, map[i][j]);
                }
            }
            return ;
        }
        // 왼쪽
        {
            int[][] newMap = new int[N][N];
            for(int i = 0; i < N; i++){
                int y = 0;
                boolean[] isPlus = new boolean[N];
                for(int j = 0; j < N; j++){
                    if(map[i][j] != 0){
                        if(y != 0 && !isPlus[y - 1] && newMap[i][y - 1] == map[i][j]){
                            newMap[i][y - 1] = map[i][j] * 2;
                            isPlus[y - 1] = true;
                        }
                        else{
                            newMap[i][y] = map[i][j];
                            y++;
                        }
                    }
                }
            }
            dfs(newMap, depth + 1);
        }
        // 아래쪽
        {
            int[][] newMap = new int[N][N];
            for(int j = 0; j < N; j++){
                int x = N - 1;
                boolean[] isPlus = new boolean[N];
                for(int i = N - 1; i >= 0; i--){
                    if(map[i][j] != 0){
                        if(x != N - 1 && !isPlus[x + 1] && newMap[x + 1][j] == map[i][j]){
                            newMap[x + 1][j] = map[i][j] * 2;
                            isPlus[x + 1] = true;
                        }
                        else{
                            newMap[x][j] = map[i][j];
                            x--;
                        }
                    }
                }
            }
            dfs(newMap, depth + 1);
        }
        // 오른쪽
        {
            int[][] newMap = new int[N][N];
            for(int i = 0; i < N; i++){
                int y = N - 1;
                boolean[] isPlus = new boolean[N];
                for(int j = N - 1; j >= 0; j--){
                    if(map[i][j] != 0){
                        if(y != N - 1 && !isPlus[y + 1] && newMap[i][y + 1] == map[i][j]){
                            newMap[i][y + 1] = map[i][j] * 2;
                            isPlus[y + 1] = true;
                        }
                        else{
                            newMap[i][y] = map[i][j];
                            y--;
                        }
                    }
                }
            }
            dfs(newMap, depth + 1);
        }
        // 위쪽
        {
            int[][] newMap = new int[N][N];
            for(int j = 0; j < N; j++){
                int x = 0;
                boolean[] isPlus = new boolean[N];
                for(int i = 0; i < N; i++){
                    if(map[i][j] != 0){
                        if(x != 0 && !isPlus[x - 1] && newMap[x - 1][j] == map[i][j]){
                            newMap[x - 1][j] = map[i][j] * 2;
                            isPlus[x - 1] = true;
                        }
                        else{
                            newMap[x][j] = map[i][j];
                            x++;
                        }
                    }
                }
            }
            dfs(newMap, depth + 1);
        }
    }
}
