package git.Algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class B2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        StringTokenizer st;
        int target = Integer.parseInt(br.readLine());
        for(int i = 0; i < target; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < target; j++){
                int n = Integer.parseInt(st.nextToken());
                if(q.size() == target){
                    if(n > q.peek()){
                        q.poll();
                        q.offer(n);
                    }
                }
                else{
                    q.offer(n);
                }
            }
        }
        System.out.println(q.poll());
    }

}
