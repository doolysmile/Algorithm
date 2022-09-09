package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N  =Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] num = new int[N];
        String[] str = new String[N];
        int[] input = new int[M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            str[i] = st.nextToken();
            num[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < M ; i++){
            int tmp = Integer.parseInt(br.readLine());
            int left = 0;
            int right = N - 1;
            while(left <= right){
                int mid = (left + right) / 2;
                if(num[mid] < tmp){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
            sb.append(str[left]  + "\n");
        }
        System.out.print(sb.toString());
    }
}
