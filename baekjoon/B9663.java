package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B9663 {
    static int N;
    static int cnt;

    static ArrayList<Integer> chess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = 0;
        chess = new ArrayList<Integer>();
        dfs(0);

        System.out.print(cnt);
    }
    static void dfs(int depth){
        if(depth == N){
            cnt++;
            return;
        }
        for(int i = depth * N; i < N *(depth + 1); i++){
            if(check(i)){
                chess.add(i);
                dfs(depth + 1);
                chess.remove((Object) i);
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
