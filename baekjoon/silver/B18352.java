package git.Algorithm.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B18352 {
    static ArrayList<ArrayList<Edge>> edgeList;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        edgeList = new ArrayList<>();
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i = 0; i <= N; i++){
            edgeList.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edgeList.get(from).add(new Edge(to, 1));
        }
        distance[X] = 0;
        dijkstra(X);
        for(int i = 1; i <= N; i++){
            if(distance[i] == K){
                sb.append(i).append("\n");
            }
        }
        if(sb.length() == 0){
            sb.append(-1);
        }
        System.out.println(sb);
    }

    private static void dijkstra(int target) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(target, 0));
        int index = 0;
        while(!queue.isEmpty()){
            Edge edge = queue.poll();
            int to = edge.to;
            int weight = edge.weight;
            if(distance[to] < weight){
                continue;
            }
            for(int i = 0; i < edgeList.get(to).size(); i++){
                int tempTo = edgeList.get(to).get(i).to;
                int weightTo = edgeList.get(to).get(i).weight + weight;
                if(distance[tempTo] > weightTo){
                    distance[tempTo] = weightTo;
                    queue.add(new Edge(tempTo, weightTo));
                }
            }
        }
    }

    public static class Edge implements Comparable<Edge> {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }
}
