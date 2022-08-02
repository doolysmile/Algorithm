package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] S = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int end = 0;
        int even = 0;
        int odd = 0;
        int ans = 0;
        for(int start = 0; start < N; start++){
            while(end < N){
                if(odd > K){
                    break;
                }
                if(S[end] % 2 == 0){
                    even++;
                }
                else{
                    odd++;
                }
                if(even > ans){
                    ans = even;
                }
                end++;
            }
            if(S[start] % 2 == 1){
                odd--;
            }
            else{
                even--;
            }
        }
        System.out.println(ans);
    }
}
