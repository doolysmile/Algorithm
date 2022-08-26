package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] chicken = new int[N][M];
        int sum = 0;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M ; j++){
                chicken[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < M - 2; i++){
            for(int j = i + 1; j < M - 1; j++){
                for(int k = j + 1; k < M; k++){
                    int tmpSum = 0;
                    for(int l = 0; l < N ; l++){
                        tmpSum += Math.max(Math.max(chicken[l][i], chicken[l][j]), chicken[l][k]);
                    }
                    if(tmpSum > sum){
                        sum = tmpSum;
                    }
                }
            }
        }
        System.out.print(sum);
    }
}
