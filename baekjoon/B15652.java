package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15652 {
    static int N;
    static int M;
    static ArrayList<Integer> arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        arr = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dfs(1, 0);
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
        for(int i = start; i <= N; i++){
            arr.add(i);
            dfs(i, depth+1);
            arr.remove(arr.size() - 1);
        }
    }
}
