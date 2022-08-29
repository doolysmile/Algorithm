package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B21278 {
    static int[][] map;
    static int N;
    static int ans;
    static int first;
    static int second;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        ans = Integer.MAX_VALUE;
        first = 0;
        second = 0;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[y][x] = 1;
        }
        // 위의 코드 까지가 입력
        makeCity();
        System.out.println(first + " " + second + " " + ans);
    }
    
    //치킨 집을 짓는 조합을 구하는 부분
    static void makeCity(){
        for(int i = 1; i < N ; i++){
            for(int j = i + 1; j <= N; j++){
                cal(i, j);
            }
        }
    }
    // 거리를 계산 하는 부분
    static void cal(int x, int y){
        boolean[] visited = new boolean[N + 1];
        visited[x] = true;
        visited[y] = true;
        int tmpAns = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, 0));
        q.add(new Node(y, 0));
        while(!q.isEmpty()){
            Node tmpNode = q.poll();
            for(int i = 1; i <= N; i++){
                if(visited[i] == false && map[tmpNode.dot][i] != 0){
                    visited[i] = true;
                    tmpAns = tmpAns + tmpNode.dis + 2;
                    q.add(new Node(i, tmpNode.dis + 2));
                }
            }
        }
        if(tmpAns < ans){
            ans = tmpAns;
            first = x;
            second = y;
        }

    }
    // q에 넣기 위해 사용한 자료 구조, 점의 위치와 거리를 넣어줌
    static class Node{
        int dot;
        int dis;
        Node(int dot, int dis){
            this.dot = dot;
            this.dis = dis;
        }
    }
}
