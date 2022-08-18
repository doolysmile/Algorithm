package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] tomato = new int[N][M];
        int cntTomato = 0;
        int cntMinusTomato = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        /*
        max 값을 0으로 설정하면 
        1 -1
        -1 1
        인 예제에서 -1로 나옴 주의
         */
        int max = 1;
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if(tomato[i][j] == 1){
                    q.add(new Node(i,j));
                    cntTomato++;
                } else if(tomato[i][j] == -1){
                    cntMinusTomato++;
                }
            }
        }
        while(!q.isEmpty()){
            Node temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            for(int i = 0; i < 4; i++){
                int temp_x = x;
                int temp_y = y;
                if(0 <= x +dx[i] && x + dx[i] < N){
                    temp_x += dx[i];
                }
                if(0 <= y +dy[i] && y + dy[i] < M){
                    temp_y += dy[i];
                }
                if(tomato[temp_x][temp_y] == 0){
                    tomato[temp_x][temp_y] = tomato[x][y] + 1;
                    if(tomato[temp_x][temp_y] > max){
                        max = tomato[temp_x][temp_y];
                    }
                    q.add(new Node(temp_x,temp_y));
                    cntTomato++;
                }
            }
        }
        max = cntTomato == M*N - cntMinusTomato? max -1 : -1;
        System.out.println(max);
    }
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
