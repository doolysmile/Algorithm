package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        boolean check = true;
        String str = br.readLine();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '<'){
                sb.append(tmp.reverse());
                tmp = new StringBuilder();
                tmp.append(c);
                check = false;
            }
            else if(c == '>'){
                tmp.append(c);
                sb.append(tmp);
                tmp = new StringBuilder();
                check = true;

            }
            else if(c == ' '){
                if(check){
                    sb.append(tmp.reverse() + " ");
                    tmp = new StringBuilder();
                }
                else{
                    tmp.append(c);
                }
            }
            else{
                tmp.append(c);
            }
            if(i == str.length() - 1){
                if(c == '>'){
                    sb.append(tmp);
                }
                else{
                    sb.append(tmp.reverse());
                }
            }
        }
        System.out.println(sb.toString());
    }
}
