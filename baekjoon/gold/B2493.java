package git.Algorithm.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int ans = 0;
            int temp = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()){
                if(stack.peek()[0] > temp){
                    ans = stack.peek()[1];
                    stack.push(new int[]{temp, i + 1});
                    break;
                }
                else{
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                stack.push(new int[]{temp, i + 1});
            }
            sb.append(ans + " ");
        }
        System.out.print(sb.toString());
    }

}
