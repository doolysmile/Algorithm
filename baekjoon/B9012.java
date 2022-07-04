package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class B9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Stack<String> s;
        for(int i = 0; i < T; i++){
            String[] ps = br.readLine().split("");
            s = new Stack<>();
            for(int j = 0; j < ps.length; j++){
                if(ps[j].equals("(")){
                    s.push(ps[j]);
                }
                else if(ps[j].equals(")")){
                    if(s.isEmpty()){
                        sb.append("NO\n");
                        break;
                    }
                    s.pop();
                }
                if(j == ps.length - 1){
                    if(s.isEmpty()){
                        sb.append("YES\n");
                    }
                    else{
                        sb.append("NO\n");
                    }
                }

            }
        }
        System.out.println(sb.toString());
    }
}
