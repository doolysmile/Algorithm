package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = new int[10];
        int sum = 0;
        int preSum = 0;
        for(int i = 0; i < 10; i++){
            preSum = sum;
            sum += Integer.parseInt(br.readLine());
            if(sum >= 100){
                sum = ((sum - 100) - (100 - preSum) <= 0) ? sum : preSum;
                break;
            }
        }
        System.out.println(sum);
    }
}
