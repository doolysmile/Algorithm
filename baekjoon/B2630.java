package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2630 {
    static int whiteCnt;
    static int blueCnt;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        whiteCnt = 0;
        blueCnt = 0;
        map = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cal(1, 1, N);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }
    static void cal(int startX, int startY, int size){
        int temp = map[startX][startY];
        boolean check = false;
        for(int i = startX; i < startX + size; i++){
            for(int j = startY; j < startY + size; j++){
                if(temp != map[i][j]){
                    check = true;
                }
            }
        }
        size = size/2;
        if(!check){
            if(temp == 0){
                whiteCnt++;
            }
            else{
                blueCnt++;
            }
            return;
        }
        else{
            cal(startX, startY, size);
            cal(startX + size, startY, size);
            cal(startX, startY + size, size);
            cal(startX + size, startY + size, size);
        }
    }
}
