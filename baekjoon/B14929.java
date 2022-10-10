package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long N = Integer.parseInt(br.readLine());
        long mul = 0;
        long ans = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            long temp = Integer.parseInt(st.nextToken());
            ans += temp*mul;
            mul += temp;
        }
        System.out.println(ans);
    }
}
