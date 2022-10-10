package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sum = new int[N + 1];
        long ans = 0;
        st = new StringTokenizer(br.readLine());
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 1; i <= N; i++){
            sum[i] = (sum[i - 1] + Integer.parseInt(st.nextToken())) % M;
            ans += map.getOrDefault(sum[i], 0);
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        System.out.println(ans);
    }
}
