package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            String temp = br.readLine();
            if(check(temp)){
                sb.append("Infected!\n");
            }
            else{
                sb.append("Good\n");
            }
        }
        System.out.println(sb.toString());
    }
    public static boolean check(String str){
        String chk1 = "ABCDEF";
        char[] chk2 = {'A', 'F', 'C'};
        int index = 0;
        int cnt = 0;
        for(int i = 0; i < str.length(); i++){
            char temp = str.charAt(i);
            if(i == 0){
                if(!chk1.contains(String.valueOf(temp))){
                    return false;
                }
                if(temp == 'A'){
                    cnt++;
                }
                continue;
            }
            if(i == str.length() - 1){
                if(!chk1.contains(String.valueOf(temp))){
                    return false;
                }
                break;
            }
            if(temp == chk2[index]){
                cnt++;
            }
            else if(cnt > 0){
                index++;
                if(index > 2){
                    return false;
                }
                if(!(temp == chk2[index])){
                    return false;
                }
                cnt = 1;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
