package git.Algorithm.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3109 {
    static String[][] map;
    static boolean[][] isVisited;
    static int R;
    static int C;
    static int ans;
    static boolean escape;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ans = 0;
        map = new String[R][C];
        isVisited = new boolean[R][C];
        for(int i = 0; i < R; i++){
            map[i] = br.readLine().split("");
        }
        // dfs를 돌림 첫 열은 영향을 안줌
        for(int i = 0; i < R; i++){
            if(map[i][1].equals(".")){
                escape = false;
                isVisited[i][1] = true;
                dfs(i, 1);
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int i, int depth) {
        // 종료 조건
        if(escape){
            return;
        }
        if(depth == (C - 2)){
            escape = true;
            ans++;
            return;
        }
        // 오른쪽 위 탐색
        if(i != 0 && !isVisited[i - 1][depth + 1] && map[i - 1][depth + 1].equals(".") ){
            isVisited[i - 1][depth + 1] = true;
            dfs(i - 1, depth + 1);
        }
        // 종료 조건
        if(escape){
            return;
        }
        // 오른쪽 탐색
        if(!isVisited[i][depth + 1] && map[i][depth + 1].equals(".") ){
            isVisited[i][depth + 1] = true;
            dfs(i, depth + 1);
        }
        // 종료 조건
        if(escape){
            return;
        }
        // 오른쪽 아래 탐색
        if(i != (R - 1) && !isVisited[i + 1][depth + 1] && map[i + 1][depth + 1].equals(".") ){
            isVisited[i + 1][depth + 1] = true;
            dfs(i + 1, depth + 1);
        }
        // 종료 조건
        if(escape){
            return;
        }

    }
}