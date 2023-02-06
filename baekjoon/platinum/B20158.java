package git.Algorithm.baekjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B20158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        int[] dx = {1, 0 , -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][][][] time = new int[N + 1][N + 1][N + 1][4];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    map[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= N; j++){
                for (int k = 1; k <= N; k++){
                    Arrays.fill(time[i][j][k], -1);
                }
            }
        }
        for(int i = 0; i < 4; i++){
            time[1][1][0][i] = 0;
        }
        Queue<Node> q = new LinkedList<>();
        if(map[1][2] > 1){
            q.add(new Node(1, 2, 1, 1));
            time[1][2][1][1] = 1;
        }
        if(map[2][1] > 1){
            q.add(new Node(2, 1, 1, 0));
            time[2][1][1][0] = 1;
        }
        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int speed = node.speed;
            int direction = node.direction;
            int curTime = time[x][y][speed][direction];
            if(x == N && y == N){
                System.out.println(curTime);
                return;
            }
            for(int i = 0; i < 4; i++){
                int nextSpeed = direction == i ? speed + 1 : 1;
                int nextX = x + dx[i]*nextSpeed;
                int nextY = y + dy[i]*nextSpeed;
                if(nextX < 1 || nextY < 1 || nextX > N || nextY > N || time[nextX][nextY][nextSpeed][i] != -1 || curTime + 1 > map[nextX][nextY] ){
                    continue;
                }
                boolean canVisited = true;

                for(int col = x, row = y; col <= nextX && row <= nextY ; col += dx[i], row += dy[i]){

                    if(map[col][row] < curTime + 1){
                        canVisited = false;
                        break;
                    }
                }
                if(canVisited){
                    time[nextX][nextY][nextSpeed][i] = curTime + 1;
                    q.add(new Node(nextX, nextY, nextSpeed, i));
                }
            }
        }
        System.out.println("Fired");
    }
    static class Node{
        int x;
        int y;
        int speed;
        int direction;
        public Node(int x, int y, int speed, int direction) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.direction = direction;
        }
    }
}