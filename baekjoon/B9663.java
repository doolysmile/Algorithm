package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B9663 {
    static int N;
    static int cnt;

    static int[] chess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = 0;
        chess = new int[N];
        dfs(0);

        System.out.print(cnt);
    }
    static void dfs(int depth){
        if(depth == N){
            cnt++;
            return;
        }
        for(int i = depth * N; i < N *(depth + 1); i++){
            if(check(i, depth)){
                chess[depth] = i;
                dfs(depth + 1);
            }
        }
    }
    static boolean check(int current, int depth){
        int y = current % N;
        for(int k = 0; k < depth; k++){
            int i = chess[k] / N;
            int j = chess[k] % N;
            if(j == y || Math.abs(depth - i) == Math.abs(y - j)){
                return false;
            }
        }
        return true;
    }
}
