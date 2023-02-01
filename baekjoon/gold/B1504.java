package git.Algorithm.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1504 {
    static ArrayList<ArrayList<Node>> nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long ans = -1;
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        nodes = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            nodes.add(new ArrayList<>());
        }
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes.get(from).add(new Node(to, weight));
            nodes.get(to).add(new Node(from, weight));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int[] distanceV1 = new int[N + 1];
        int[] distanceV2 = new int[N + 1];
        distanceV1 = dijkstra(v1, N);
        distanceV2 = dijkstra(v2, N);
        ans = Math.min((long) distanceV1[v2] + distanceV1[1] + distanceV2[N],
                (long) distanceV1[v2] + distanceV1[N] + distanceV2[1]);
        if(ans >= Integer.MAX_VALUE){
            ans = -1;
        }
        System.out.println(ans);
    }

    private static int[] dijkstra(int v1, int N) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        int[] ans = new int[N + 1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[v1] = 0;
        q.add(new Node(v1, 0));
        while(!q.isEmpty()){
            Node node = q.poll();
            int from = node.to;
            int weight = node.weight;
            for(int i = 0; i < nodes.get(from).size(); i++){
                int to = nodes.get(from).get(i).to;
                int newWeight = nodes.get(from).get(i).weight + weight;
                if(newWeight < ans[to]){
                    ans[to] = newWeight;
                    q.add(new Node(to, newWeight));
                }
            }
        }
        return ans;
    }

    static class Node implements Comparable<Node>{
        int to;
        int weight;

        Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}