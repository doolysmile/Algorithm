package git.Algorithm.programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution118667 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int len = queue1.length;
        long sumq1 = 0;
        long sumq2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i = 0; i < len; i++){
            q1.add(queue1[i]);
            sumq1 += queue1[i];
        }
        for(int i = 0; i < len; i++){
            q2.add(queue2[i]);
            sumq2 += queue2[i];
        }
        for(int i = 0; i < len*3; i++){
            System.out.println(i);
            System.out.println(sumq1);
            System.out.println(sumq2);
            if(sumq1 > sumq2){
                int temp = q1.poll();
                q2.add(temp);
                sumq2 += temp;
                sumq1 -= temp;
                answer++;
            }
            else if(sumq1 < sumq2){
                int temp = q2.poll();
                q1.add(temp);
                sumq1 += temp;
                sumq2 -= temp;
                answer++;
            }
            else{
                break;
            }
            if(i == (len*3 - 1)){
                answer = -1;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Solution118667 s = new Solution118667();
        int[] q1 = {3, 2, 7, 2};
        int[] q2 = {4, 6, 5, 1};
        s.solution(q1, q2);
    }
}
