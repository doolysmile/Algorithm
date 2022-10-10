package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
for문으로 풀이 시 시간 초과 남 : 아래 풀이는 시간 초과
map : 검색이 빠름 
 */
public class B2015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int temp = 0;
        long ans = 0;
        int[] sum = new int[N + 1];
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 1; i <= N ; i++){
            temp = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + temp;
            ans += map.getOrDefault(sum[i] - K, 0);
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        System.out.println(ans);
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());
//        int temp = 0;
//        int ans = 0;
//        int[] sum = new int[N + 1];
//        for(int i = 1; i <= N ; i++){
//            temp = Integer.parseInt(st.nextToken());
//            sum[i] = sum[i - 1] + temp;
//            if(sum[i] == K){
//                ans++;
//            }
//            for(int j = 1; j < i; j++){
//                if(sum[i] - sum[j] == K){
//                    ans++;
//                }
//            }
//        }
//        System.out.println(ans);
//    }

}
