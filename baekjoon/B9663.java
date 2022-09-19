package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B9663 {
    static int N;
    static int cnt;
    static boolean[] visited;
    static ArrayList<Integer> chess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = 0;
        visited = new boolean[N*N];
        dfs(0, 0);
        chess = new ArrayList<Integer>();

        System.out.print(cnt);
    }
    static void dfs(int depth, int current){
        if(depth == N){
            cnt++;
            return;
        }
        for(int i = current; i < N * N; i++){
            if(visited[i] == false && check(i)){
                visited[i] = true;
                chess.add(i);
                dfs(depth + 1, i);
                chess.remove((Object) i);
                visited[i] = false;
            }
        }
    }
    static boolean check(int current){
        int x = current / N;
        int y = current % N;
        for(int k = 0; k < chess.size(); k++){
            int temp = chess.get(k);
            int i = temp / N;
            int j = temp % N;
            if(i == x || j == y || Math.abs(x - i) == Math.abs(y - j)){
                return false;
            }
        }
        return true;
    }
}
