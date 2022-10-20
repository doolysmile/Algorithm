package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            String tmp = br.readLine();
            sb.append(check(tmp) + "\n");
        }
        System.out.println(sb.toString());
    }
    /*
    0 : 회문
    1 : 유사 회문
    2 : 둘 다 아님
     */
    public static int check(String str){
        int start = 0;
        int end = str.length() - 1;
        int ans = 0;
        int saveStart = 0;
        int saveEnd = 0;
        boolean startCheck = true;
        boolean endCheck = true;
        while(start < end){
            if(str.charAt(start) == str.charAt(end)){
                start++;
                end--;
                continue;
            }
            else{
                ans++;
            }
            if(ans >= 1 && startCheck){
                saveStart = start;
                saveEnd = end;
                startCheck = false;
                start++;
            }
            else if(ans >= 2 && !startCheck && endCheck){
                endCheck = false;
                start = saveStart;
                end = saveEnd - 1;
                ans = 1;
            }

            if(ans >= 2 && !startCheck){
                break;
            }
        }
        return ans;
    }
}
