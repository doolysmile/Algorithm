package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11725 {
    static boolean[] checked;
    static int N;
    static ArrayList[] node;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        checked = new boolean[N+1];
        ans = new int[N+1];
        node = new ArrayList[N+1];
        for(int i = 1; i < N+1; i++){
            node[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < N - 1; i++){
            String[] tmp = br.readLine().split(" ");
            int c = Integer.parseInt(tmp[0]);
            int r = Integer.parseInt(tmp[1]);
            node[c].add(r);
            node[r].add(c);
        }
        dfs(1);
        for(int i = 2; i < N + 1; i++){
            System.out.println(ans[i]);
        }
    }
    public static void dfs(int current){

        if(checked[current]){
            return;
        }
        checked[current] = true;

        for(int i = 0; i < node[current].size(); i++){
            int tmp = (int) node[current].get(i);
            if(checked[tmp] == false){
                ans[tmp] = current;
                dfs(tmp);
            }
        }
    }
}
// 다른 사람 풀이
//import java.io.*;
//        import java.util.*;
//
//public class Main {
//
//    /**
//     * 노드의 개수
//     * 2 <= N <= 100,000
//     */
//    static int N;
//
//    static List<List<Integer>> graph;
//
//    public static void main(String[] args) throws IOException {
//        // io
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        // logic
//        N = Integer.parseInt(br.readLine());
//
//        graph = new ArrayList<>(N);
//        for (int i = 0; i < N; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        for (int i = 1; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//            int src = Integer.parseInt(st.nextToken()) - 1;
//            int dst = Integer.parseInt(st.nextToken()) - 1;
//
//            graph.get(src).add(dst);
//            graph.get(dst).add(src);
//        }
//
//        int[] parents = bfs();
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i < N; i++) {
//            sb.append(parents[i] + 1)
//                    .append("\n");
//        }
//
//        // output
//        bw.write(sb.toString());
//
//        // io close
//        bw.close();
//        br.close();
//    }
//
//    private static int[] bfs() {
//        int[] parents = new int[N];
//        boolean[] visited = new boolean[N];
//
//        Queue<Integer> q = new LinkedList<>();
//        q.offer(0);
//        visited[0] = true;
//
//        while (!q.isEmpty()) {
//            int parent = q.poll();
//
//            for (int child : graph.get(parent)) {
//                if (visited[child]) {
//                    continue;
//                }
//
//                q.offer(child);
//                parents[child] = parent;
//                visited[child] = true;
//            }
//        }
//
//        return parents;
//    }
//}
