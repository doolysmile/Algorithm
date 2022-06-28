package git.Algorithm.baekjoon;

import java.util.*;
import java.io.*;

public class B11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(q.size() == 0){
                    sb.append("0\n");
                }
                else{
                    sb.append(q.poll() + "\n");
                }
            }
            q.add(num);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
