package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        Queue<Node> q = new LinkedList<>();
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};
        int ans = 0;
        int sharkSize = 2;
        int eatenFish = 0;
        int curX = 0;
        int curY = 0;
        boolean check = true;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    curX = i;
                    curY = j;
                }
            }
        }
        while(check){
            check = false;
            int[][] dis = new int[N][N];
            int minDis = Integer.MAX_VALUE;
            boolean innerCheck = false;
            q.add(new Node(curX, curY));
            while (!q.isEmpty()) {
                if(innerCheck){
                    break;
                }
                Node node = q.poll();
                int x = node.x;
                int y = node.y;
                for (int i = 0; i < 4; i++) {
                    int nowX = x + dx[i];
                    int nowY = y + dy[i];
                    if (0 <= nowX && nowX < N && 0 <= nowY && nowY < N && dis[nowX][nowY] == 0) {
                        dis[nowX][nowY] = dis[x][y] + 1;
                        if(map[nowX][nowY] < sharkSize && map[nowX][nowY] != 0 ){
                            if(minDis < dis[nowX][nowY]){
                                innerCheck = true;
                                break;
                            }
                            else{
                                minDis = dis[nowX][nowY];
                            }
                        }
                        else if(map[nowX][nowY] > sharkSize){
                            continue;
                        }
                        q.add(new Node(nowX, nowY));
                    }
                }
            }
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    System.out.print(dis[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("minDis = " + minDis);

            for(int i = 0; i < N; i++){
                if(check){
                    continue;
                }
                for(int j = 0; j < N; j++){
                    if(dis[i][j] == minDis){
                        curX = i;
                        curY = j;
                        map[i][j] = 0;
                        eatenFish++;
                        ans = minDis;
                        if(eatenFish == sharkSize){
                            sharkSize++;
                            eatenFish = 0;
                        }
                        check = true;
                        continue;
                    }
                }
            }
        }
        System.out.print(ans);

    }
    public static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
