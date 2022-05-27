package git.Algorithm.programmers.lv2;
import java.util.*;
public class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        int temp = 0;
        int len = priorities.length;

        for(int i : priorities){
            q.add(i);
        }

        Arrays.sort(priorities);

        while(!q.isEmpty()){
            temp = q.poll();
            if(temp == priorities[len - answer - 1]){
                answer++;
                location--;
                if(location < 0){
                    break;
                }
            }
            else{
                q.add(temp);
                location--;
                if(location < 0){
                    location = q.size() - 1;
                }
            }

        }
        return answer;
    }
}
