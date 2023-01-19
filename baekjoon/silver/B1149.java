package git.Algorithm.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1149{
    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] house = new int[N][3];
        for(int i = 0; i < N; i++){
            int temp[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(i == 0){
                for(int j = 0; j < 3; j++){
                    house[i][j] = temp[j];
                }
            }
            else{
                house[i][RED] = Math.min(house[i - 1][GREEN] + temp[RED], house[i - 1][BLUE] +  temp[RED]);
                house[i][GREEN] = Math.min(house[i - 1][RED] + temp[GREEN], house[i - 1][BLUE] +  temp[GREEN]);
                house[i][BLUE] = Math.min(house[i - 1][RED] + temp[BLUE], house[i - 1][GREEN] +  temp[BLUE]);
            }
        }
        System.out.println(Math.min(Math.min(house[N - 1][RED], house[N - 1][GREEN]), house[N - 1][BLUE]));
    }
}