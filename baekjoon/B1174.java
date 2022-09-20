package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1174 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 10;
        long ans = -1;
        Queue<Long> q = new LinkedList<>();
        if(N <= 10 ){
            System.out.print(N - 1);
            return;
        }
        if(N > 1023){
            System.out.print(-1);
            return;
        }
        for(long i = 0; i < 10; i++){
            q.add(i);
        }
        Loop :
        while(!q.isEmpty()){
            long current = q.poll();
            long temp = current%10;
            for(int i = 0 ; i < temp; i++){
                cnt++;
                long newNum =current * 10 +  i;
                if(cnt == N){
                    ans = newNum;
                    break Loop;
                }
                q.add(newNum);
            }
        }
        System.out.print(ans);
    }
}
