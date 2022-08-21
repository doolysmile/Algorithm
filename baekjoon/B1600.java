package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1600 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][] map = new int[H][W];
        Queue<Location> q = new LinkedList<>();
        int[] x = {1, 0, -1, 0};
        int[] y = {0, 1, 0, -1};
        int[] horseX = {-1, 1, -2, 2, -2, 2, -1, 1};
        int[] horseY = {-2, -2, -1, -1, 1, 1, 2, 2};
        int ans = -1;
        boolean[][][] visited = new boolean[H][W][2];
        for(int i = 0 ; i < H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        q.add(new Location(0, 0, 0, 0));
        map[0][0] = -1;
        while(!q.isEmpty()){
            Location tmp = q.poll();
            if(tmp.x == H - 1 && tmp.y == W - 1){
                ans = tmp.cnt;
                break;
            }
            for(int i = 0; i < 4; i++){
                if(0 <= tmp.x + x[i] && tmp.x + x[i] < H && 0 <= tmp.y + y[i] && tmp.y + y[i] < W){
                    if(map[tmp.x + x[i]][tmp.y + y[i]] == 0 && visited[tmp.x + x[i]][tmp.y + y[i]][0] == false){
                        visited[tmp.x + x[i]][tmp.y + y[i]][0] = true;
                        q.add(new Location(tmp.x + x[i], tmp.y + y[i], tmp.cntHorse, tmp.cnt + 1));
                    }
                }
            }
            if(tmp.cntHorse < K){
                for(int i = 0; i < 8; i++){
                    if(0 <= tmp.x + horseX[i] && tmp.x + horseX[i] < H && 0 <= tmp.y + horseY[i] && tmp.y + horseY[i] < W){
                            if(map[tmp.x + horseX[i]][tmp.y + horseY[i]] == 0 && visited[tmp.x + horseX[i]][tmp.y + horseY[i]][1] == false){
                                visited[tmp.x + horseX[i]][tmp.y + horseY[i]][1] = true;
                                q.add(new Location(tmp.x + horseX[i], tmp.y + horseY[i], tmp.cntHorse + 1, tmp.cnt + 1));
                            }
                        }

                }
            }

        }
        System.out.print(ans);
    }
    static class Location{
        int x;
        int y;
        int cntHorse;

        int cnt;
        Location(int x, int y, int cntHorse, int cnt){
            this.x = x;
            this.y = y;
            this.cntHorse = cntHorse;
            this.cnt = cnt;
        }
    }
}
