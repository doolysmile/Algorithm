package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int ans = 0;
        for(int i = H; i >0; i--){
            boolean block = false;
            int tmp = 0;
            for(int j = 0; j < W; j++){
                if(input[j] >= i){
                    if(!block){
                        block = true;
                        tmp = j;
                    }
                    else{
                        ans = ans +  j - tmp - 1;
                        tmp = j;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
