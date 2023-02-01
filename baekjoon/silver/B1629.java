package git.Algorithm.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        long ans = div(A, B, C);
        System.out.println(ans);
    }

    private static long div(long A, long B, long C) {
        if(B == 1){
            return A % C;
        }
        if(B % 2 == 0){
            long temp = div(A,B/2, C) % C;
            return (temp * temp) % C;
        }
        else {
            long temp = div(A, B/2, C) % C;
            temp = temp * temp % C;
            return (temp * A) % C;
        }
    }
}
/*
2 4
1. a^n(2k) 2. a^n(2k + 1)
a^n/2(k)
a^n/2(k) * a
5 -> 2 -> 1 -> 0
 */
