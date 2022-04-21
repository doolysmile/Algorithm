package git.Algorithm.programmers.lv2;


import java.util.*;

public class FunctionDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> day = new Stack<>();
        Stack<Integer> ans = new Stack<>();
        for(int i = 0; i < progresses.length ; i++) {
            int temp = (100 - progresses[i]) % speeds[i] > 0 ? (100 - progresses[i]) / speeds[i] + 1 : (100 - progresses[i]) / speeds[i];
            if(day.isEmpty()){
                day.push(temp);
                ans.push(1);
            }
            else if(day.peek() >= temp) {
                int tmp = ans.pop() + 1;
                ans.push(tmp);
            }
            else {
                day.push(temp);
                ans.push(1);
            }
        }
        int[] answer = new int[ans.size()];
        for(int i = answer.length - 1; i >=0 ; i--){
            answer[i] = ans.pop();
        }
        return answer;
    }
}