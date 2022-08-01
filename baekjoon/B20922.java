package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int ans = 0;
        int tmp = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int end = 0;
        for(int start = 0; start < N; start++){
            while(end < N){
                if(map.getOrDefault(a[end], 0) >= K){
                    break;
                }
                else{
                    map.put(a[end], map.getOrDefault(a[end], 0) + 1);
                    tmp++;
                    if(tmp > ans){
                        ans = tmp;
                    }
                    end++;
                }
            }
            map.put(a[start], map.get(a[start]) - 1);
            tmp--;
        }
        System.out.println(ans);
    }
}
