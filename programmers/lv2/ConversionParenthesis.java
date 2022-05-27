package git.Algorithm.programmers.lv2;
import java.util.*;
public class ConversionParenthesis {
    public String solution(String p) {
        String answer = "";

        answer = pair(p);

        return answer;
    }
    public String pair(String p) {
        String u = "";
        String v = "";
        String ans = "";
        StringBuilder a = new StringBuilder();
        int check = 0;
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') {
                check++;
            }
            else {
                check--;
            }

            if(check == 0) {
                u = p.substring(0, i+1);
                v = p.substring(i+1, p.length());
                break;
            }
        }
        if(v == "") {
            return ans;
        }
        if(u.charAt(0) == '(') {
            a.append(u);
            a.append(pair(v));
        }
        else {
            a.append("(" + pair(v) + ")");
            for(int i = 1; i < u.length() -1 ; i++) {
                if(u.charAt(i) == '(') {
                    a.append(")");
                }
                else {
                    a.append("(");
                }
            }
        }
        ans = a.toString();

        return ans;
    }
}
