package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[N + 1];
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        int[][] graph = new int[N + 1][N + 1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = 1;
        }
        q.add(1);
        check[1] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i = 1; i <= N; i++){
                if(graph[temp][i] == 1 && check[i] == false){
                    check[i] = true;
                    ans++;
                    q.add(i);
                }
            }
        }
        System.out.println(ans);
    }
}
