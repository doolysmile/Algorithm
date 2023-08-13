package git.Algorithm.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] high = new int[H + 1];    // 석순 정보
        int[] low = new int[H + 1];     // 종유석 정보
        int min = Integer.MAX_VALUE;
        int cnt = 1;
        for(int i = 1; i <= N/2; i++){
            high[Integer.parseInt(br.readLine())]++;
            low[Integer.parseInt(br.readLine())]++;
        }
        // 누적합
        int[] sumHigh = new int[H + 1];
        int[] sumLow = new int[H + 1];
        for(int i = 1; i <= H; i++){
            sumHigh[i] = sumHigh[i - 1] + high[i];
            sumLow[i] = sumLow[i - 1] + low[i];
        }
        for(int i = 1; i <= H ; i++){
            int crush = 0;

            crush = crush + sumLow[H] - sumLow[i - 1];
            crush = crush + sumHigh[H] - sumHigh[H - i];

            if(crush < min){
                min = crush;
                cnt = 1;
            }
            else if(crush == min){
                cnt++;
            }
        }
        System.out.println(min + " " + cnt);
    }
}