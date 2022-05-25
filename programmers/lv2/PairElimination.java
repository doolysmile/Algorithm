package git.Algorithm.programmers.lv2;
import java.util.*;
public class PairElimination {
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        char temp;
        for(int i = 0; i < s.length(); i++){
            temp = s.charAt(i);
            if(!stack.empty() && stack.peek() == temp){
                stack.pop();
            } else{
                stack.push(temp);
            }
        }
        if(stack.size() == 0){
            answer = 1;
        }

        return answer;
    }
}
