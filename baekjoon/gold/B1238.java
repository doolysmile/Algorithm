package git.Algorithm.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1238 {
    static int[] distanceReverse;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Road>> roads = new ArrayList<>();
        ArrayList<ArrayList<Road>> roadsReverse = new ArrayList<>();
        int ans = 0;
        for(int i = 0; i <= N; i++){
            roads.add(new ArrayList<>());
            roadsReverse.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            roads.get(from).add(new Road(to, weight));
            roadsReverse.get(to).add(new Road(from, weight));
        }
        int[] distance = dijkstra(X, N, roads);
        int[] distanceReverse = dijkstra(X, N, roadsReverse);
        for(int i = 1; i <= N; i++){
            if(distance[i] + distanceReverse[i] > ans){
                ans = distance[i] + distanceReverse[i];
            }
        }
        System.out.println(ans);
    }
    private static int[] dijkstra(int target, int size, ArrayList<ArrayList<Road>> roads) {
        int[] ans = new int[size + 1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[target] = 0;
        PriorityQueue<Road> q = new PriorityQueue<>();
        q.add(new Road(target, 0));
        while(!q.isEmpty()){
            Road cur = q.poll();
            int from = cur.to;
            int weight = cur.weight;
            if(weight > ans[from]){
                continue;
            }
            for(int i = 0; i < roads.get(from).size(); i++){
                int to = roads.get(from).get(i).to;
                int newWeight = roads.get(from).get(i).weight + weight;
                if(newWeight < ans[to]){
                    ans[to] = newWeight;
                    q.add(new Road(to, newWeight));
                }
            }
        }
        return ans;
    }
    static class Road implements Comparable<Road> {
        int to;
        int weight;
        Road(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Road o) {
            return weight - o.weight;
        }
    }
}