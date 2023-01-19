package git.Algorithm.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1967 {
    static ArrayList<ArrayList<Node>> tree;
    static int[] weight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int V = Integer.parseInt(br.readLine());
        if(V == 0){
            System.out.println(0);
            return;
        }
        tree = new ArrayList<>();
        for(int i = 0; i <= V; i++){
            tree.add(new ArrayList<>());
        }
        for(int i = 0; i < V - 1; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree.get(node1).add(new Node(node2, weight));
            tree.get(node2).add(new Node(node1, weight));
        }
        int target = bfs(bfs(1, V), V);

        System.out.println(weight[target]);

    }
    public static int bfs(int start, int V){
        boolean[] isVisited = new boolean[V + 1];
        isVisited[start] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        weight = new int[V + 1];
        int max = Integer.MIN_VALUE;
        int ans = -1;
        while (!q.isEmpty()){
            Node cur = q.poll();
            for(Node node : tree.get(cur.to)){
                if(!isVisited[node.to]){
                    isVisited[node.to] = true;
                    q.add(node);
                    weight[node.to] = weight[cur.to] + node.weight;
                    if(weight[node.to] > max){
                        max = weight[node.to];
                        ans = node.to;
                    }
                }
            }
        }
        return  ans;
    }
    static class Node{
        int to;
        int weight;
        Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
}