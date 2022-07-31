package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] rec = new int[size[0] + 1][size[1] + 1];
        for(int i = 1; i <= size[0]; i++){
            st = new StringTokenizer(br.readLine());
            rec[i][1] = Integer.parseInt(st.nextToken());
            for(int j = 2; j <= size[1]; j++){
                rec[i][j] = rec[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }
        int K = Integer.parseInt(br.readLine());
        int[][] recRange = new int[K][4];
        for(int i = 0 ; i < K ; i++){
            int sumTmp = 0;
            recRange[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = recRange[i][0]; j <= recRange[i][2]; j++){
                sumTmp += rec[j][recRange[i][3]] - rec[j][recRange[i][1] -1];
            }
            sb.append(sumTmp + "\n");
        }
        System.out.println(sb.toString());
    }
}
