package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        String[][] map = new String[R][C];
        String[][] afterMap = new String[R][C];
        int[] moveX = {1, 0, -1, 0};
        int[] moveY = {0, 1, 0, -1};
        int leftTopX = R;
        int leftTopY = C;
        int rightBottomX = 0;
        int rightBottomY = 0;
        for(int i = 0; i < R; i++){
            map[i] = br.readLine().split("");
        }
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                int cnt = 0;
                for(int k = 0; k < 4; k++){
                    int x = i + moveX[k];
                    int y = j + moveY[k];
                    if(0 <= x && x < R && 0 <= y && y < C){
                        if(map[x][y].equals(".")){
                            cnt++;
                        }
                    }
                    else if(x == -1 || x == R || y == -1 || y == C){
                        cnt++;
                    }
                }
                if(cnt >= 3){
                    afterMap[i][j] = ".";
                }
                else{
                    afterMap[i][j] = map[i][j];
                    if(afterMap[i][j].equals("X")){
                        leftTopX = Math.min(leftTopX, i);
                        leftTopY = Math.min(leftTopY, j);
                        rightBottomX = Math.max(rightBottomX, i);
                        rightBottomY = Math.max(rightBottomY, j);
                    }
                }
            }
        }


        for(int i = leftTopX; i <= rightBottomX; i++){
            for(int j = leftTopY; j <= rightBottomY; j++){
                sb.append(afterMap[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
