package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2961 {
    static int ans;
    static int N;
    static boolean[] visited;
    static int[][] taste;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        taste = new int[N][2];
        ans = Integer.MAX_VALUE;
        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            taste[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        dfs(0 , 0, 1, 0);
        System.out.println(ans);
    }
    static void dfs(int cnt, int current, int s, int b){
        if(s - b == 0){
            ans = 0;
            return;
        }
        if(cnt == N){
            if(s != 1 && b != 0){
                ans = Math.min(ans, Math.abs(s - b));
            }
            return;
        }
        dfs(cnt + 1,current + 1, s*taste[current][0], b + taste[current][1]);
        dfs(cnt + 1, current+ 1, s, b);
    }
}
