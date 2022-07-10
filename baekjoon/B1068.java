package git.Algorithm.baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        for(int i = 0; i < N; i++){
            nodes[i] = new Node();
        }

        Queue<Integer> q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        int answer = 0;
        for(int i = 0; i < N ; i++){
            int parent;
            parent = Integer.parseInt(st.nextToken());
            if(parent != -1){
                nodes[parent].child.add(i);
            }
            nodes[i].parent = parent;
        }

        q.offer(Integer.parseInt(br.readLine()));
        while(!q.isEmpty()){
            int remove = q.poll();
            int parent = nodes[remove].parent;
            for(int i = 0; i < nodes[remove].child.size(); i++){
                q.offer(nodes[remove].child.get(i));
            }
            if(parent != -1){
                nodes[parent].child.remove((Object)remove);
            }
            nodes[remove].child = new ArrayList<>();
            nodes[remove].parent = -2;
        }
        for(int i = 0; i < N; i++){
            if(nodes[i].parent != -2 && nodes[i].child.size() ==0){
                answer++;
            }
        }
        System.out.println(answer);
    }
    static class Node {
        int parent;
        ArrayList<Integer> child = new ArrayList<>();
    }
}
