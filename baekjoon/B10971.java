package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10971 {
    static boolean[] visited;
    static int cost;
    static int N;
    static int[][] W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        W = new int[N][N];
        cost = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N; i++){
            visited[i] = true;
            dfs(1, i, i,0);
            visited[i] = false;
        }
        System.out.print(cost);
    }
    public static void dfs(int depth, int current, int start, int sum){
        if(depth == N){
            if(W[current][start] != 0 && sum + W[current][start] != 0 && sum + W[current][start] < cost){
                cost = sum + W[current][start];
            }
        }
        for(int i = 0; i < N; i++){
            if(!visited[i] && W[current][i] != 0){
                visited[i] = true;
                dfs(depth + 1, i, start, sum + W[current][i]);
                visited[i] = false;
            }
        }
    }
}
