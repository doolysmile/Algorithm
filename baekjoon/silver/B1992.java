package git.Algorithm.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1992 {
    static int[][] map;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        sb = new StringBuilder();
        // 입력을 받는 부분
        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        makeString(0, 0, N);
        System.out.println(sb);
    }
    // 괄호 만드는 재귀문
    private static void makeString(int x, int y, int n) {
        // 다 0이나 1로 구성 되어있는가 확인
        int temp = map[x][y];
        boolean isPossible = true;
        Loop:
        for(int i = x; i < x + n; i++){
            for(int j = y; j < y + n; j++){
                if(map[i][j] != temp){
                    isPossible = false;
                    break Loop;
                }
            }
        }
        if(isPossible){
            sb.append(temp);
            return;
        }
        // 괄호 열기
        sb.append("(");
        n = n / 2;
        // 각 사분면 호출
        makeString(x, y, n);
        makeString(x, y + n, n);
        makeString(x + n, y, n);
        makeString(x + n, y + n, n);
        // 괄호 닫기
        sb.append(")");
    }
}
