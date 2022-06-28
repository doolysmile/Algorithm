package git.Algorithm.baekjoon;

import java.io.*;
import java.util.*;

public class B11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> q = new PriorityQueue<>(((a, b) ->
                Math.abs(a) == Math.abs(b) ? a - b : Math.abs(a) - Math.abs(b)));
        // 다른 방법
        /*
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                 if(Math.abs(o1)>Math.abs(o2)){
                     return 1;
                 } else if(Math.abs(o1)==Math.abs(o2)){
                     return o1-o2;
                 } else{
                     return -1;
                 }
            }
        });
         */
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                if(q.size()==0){
                    sb.append("0\n");
                }
                else{
                    sb.append(q.poll() + "\n");
                }
            }
            else{
                q.add(num);
            }

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
