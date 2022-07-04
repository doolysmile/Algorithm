package git.Algorithm.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int N = sc.nextInt();
        int K = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ; i <= N; i++){
            q.offer(i);
        }
        while(true){
            for(int i = 0; i < K - 1; i++){
                q.offer(q.poll());
            }
            sb.append(q.poll());
            if(q.isEmpty()){
                sb.append(">");
                break;
            }
            else{
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }
}
