package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] input = new int[N][2];
        Queue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            input[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Arrays.sort(input, (a,b)-> a[0]-b[0]);
        q.add(input[0][1]);
        for(int i = 1; i < N; i++){
            if(q.peek() <= input[i][0]){
                q.poll();
            }
            q.offer(input[i][1]);
        }
        System.out.println(q.size());
    }
}
