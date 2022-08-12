package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int[][] resArr = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /* M
 order  11 12 13    12 13 23
   N    21 22 23    11 22 33
 N-j-1  31 32 33    21 31 32
         */
        int order = N < M ? N/2 : M/2;

        for(int i = 0; i < R; i++){
            for(int j = 0; j < order; j++){
                int temp = arr[j][j];
                for(int k = j; k < M - j - 1; k++){ // 윗 줄
                    arr[j][k] = arr[j][k + 1];
                }
                for(int k = j; k < N - j - 1; k++){ // 오른쪽 줄
                    arr[k][M - j - 1] = arr[k + 1][M - j - 1];
                }
                for(int k = M - j - 1; k > j ; k--){  //아랫 줄
                    arr[N - j - 1][k] = arr[N - j - 1][k - 1];
                }
                for(int k = N - j - 1; k > j; k--){
                    arr[k][j] = arr[k - 1][j];
                }
                arr[j + 1][j] = temp;
            }
        }
        for(int I = 0; I < N; I++){
            for(int J = 0; J < M; J++){
                sb.append(arr[I][J] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
