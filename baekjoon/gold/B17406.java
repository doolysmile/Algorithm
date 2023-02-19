package git.Algorithm.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17406 {
    static int S;
    static boolean[] isVisited;
    static int N;
    static int M;
    static int[][] command;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        command = new int[S][3];
        isVisited = new boolean[S + 1];
        ans = Integer.MAX_VALUE;
        int[][] arr = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < S; i++){
            st = new StringTokenizer(br.readLine());
            command[i][0] = Integer.parseInt(st.nextToken());
            command[i][1] = Integer.parseInt(st.nextToken());
            command[i][2] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0, arr);
        System.out.println(ans);
    }

    private static void dfs(int cur, int depth, int[][] arr) {
        // 종료 조건
        if(depth == S){
            for(int i = 1; i <= N; i++){
                int temp = 0;
                for(int j = 1; j <= M ; j++){
                    temp = temp + arr[i][j];
                }
                ans = Math.min(ans, temp);
            }
            return;
        }
        // dfs 탐색
        for(int i = 0; i < S; i++){
            if(!isVisited[i]){
                int[][] temp = new int[N + 1][M + 1];
                for(int k = 1; k <= N; k++){
                    for(int j = 1; j <= M; j++){
                        temp[k][j] = arr[k][j];
                    }
                }
                isVisited[i] = true;
                temp = rotate(command[i][0] - command[i][2], command[i][1] - command[i][2], command[i][0] + command[i][2], command[i][1] + command[i][2], temp);
                dfs(cur, depth + 1, temp);
                isVisited[i] = false;
            }
        }
    }

    private static int[][] rotate(int startX, int startY, int endX, int endY, int[][] arr) {
        int min = Math.min(endX - startX + 1, endY - startY + 1);
        // 왼쪽 제일 위 저장
        min = min/2;
        for(int i = 0; i < min; i++){
            int temp = arr[startX + i][startY + i];
            // 왼쪽
            for(int x = startX + i; x < endX - i; x++){
                arr[x][startY + i] = arr[x + 1][startY + i];
            }
            // 아래쪽
            for(int y = startY + i; y < endY - i; y++){

                arr[endX - i][y] = arr[endX - i][y + 1];
            }
            // 오른쪽
            for(int x = endX - i; x > startX + i; x--){
                arr[x][endY - i] = arr[x - 1][endY- i];
            }
            for(int y = endY - i; y > startY + i; y--){
                arr[startX + i][y] = arr[startX + i][y - 1];
            }
            arr[startX + i][startY + 1 + i] = temp;
        }
        return arr;
    }
}