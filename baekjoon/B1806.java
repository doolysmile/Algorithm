package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int end = 0;
        int sum = 0;
        int ans = N + 1;
        for(int start = 0; start < N; start++){
            while(end < N){
                if(sum >= S){
                    break;
                }
                sum += input[end++];
                if(sum >= S){
                    ans = end - start < ans ? end - start : ans;
                    break;
                }
            }
            sum -= input[start];
            if(sum >= S){
                ans = end - start - 1 < ans ? end - start - 1: ans;
            }
        }
        ans = ans == N + 1 ? 0 : ans;
        System.out.println(ans);
    }
}
