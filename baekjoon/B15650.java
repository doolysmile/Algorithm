package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15650 {
    static int N;
    static int M;
    static boolean[] visited;
    static ArrayList<Integer> arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        arr = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        dfs(0,0);
        System.out.print(sb.toString());
    }
    public static void dfs(int start, int depth){
        if(depth == M) {
            for(int i : arr){
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start + 1; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr.add(i);
                dfs(i, depth+1);
                arr.remove(arr.size() - 1);
                visited[i] = false;
            }
        }
    }
}
