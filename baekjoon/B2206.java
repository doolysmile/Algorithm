package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[] x = {1, 0, -1, 0};
        int[] y = {0, 1, 0, -1};
        Queue<Location> q = new LinkedList<>();
        int ans = -1;
        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        boolean[][][] visited = new boolean[N][M][2];
        q.add(new Location(0,0, 1, false));
        while(!q.isEmpty()){
            Location tmp = q.poll();
            if(tmp.x == N - 1 && tmp.y == M -1){
                ans = tmp.cnt;
                break;
            }
            for(int i = 0; i < 4; i++){

                if(0 <= tmp.x + x[i] && tmp.x + x[i] < N && 0 <= tmp.y + y[i] && tmp.y + y[i] < M){
                    if(map[tmp.x + x[i]][tmp.y + y[i]] == 0 ){
                        if(tmp.wall == false && visited[tmp.x + x[i]][tmp.y + y[i]][0] == false){
                            visited[tmp.x + x[i]][tmp.y + y[i]][0] = true;
                            q.add(new Location(tmp.x + x[i], tmp.y + y[i], tmp.cnt + 1, tmp.wall));
                        }
                        else if(tmp.wall == true && visited[tmp.x + x[i]][tmp.y + y[i]][1] == false){
                            visited[tmp.x + x[i]][tmp.y + y[i]][1] = true;
                            q.add(new Location(tmp.x + x[i], tmp.y + y[i], tmp.cnt + 1, true));
                        }

                    }
                    if(map[tmp.x + x[i]][tmp.y + y[i]] == 1 && visited[tmp.x + x[i]][tmp.y + y[i]][1] == false && tmp.wall == false){
                        visited[tmp.x + x[i]][tmp.y + y[i]][1] = true;
                        q.add(new Location(tmp.x + x[i], tmp.y + y[i], tmp.cnt + 1, true));
                    }
                }
            }
        }
        System.out.println(ans);
    }
    static class Location{
        int x;
        int y;
        int cnt;
        boolean wall;
        Location(int x, int y, int cnt, boolean wall){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.wall = wall;
        }
    }
}
