package git.Algorithm.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B23888 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());

            int com = Integer.parseInt(st.nextToken());
            long l = Integer.parseInt(st.nextToken());
            long r = Integer.parseInt(st.nextToken());
            long left = a + (l - 1)*d;
            long right = a + (r - 1)*d;
            if(com == 1){
                sb.append((left + right)*(r - l + 1)/2);
            }
            else{
                if(l == r){
                    sb.append(left);
                }
                else{
                    sb.append(gcd(a, d));
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static long gcd(long p, long q)
    {
        if (q == 0)
            return p;
        return gcd(q, p%q);
    }
}
