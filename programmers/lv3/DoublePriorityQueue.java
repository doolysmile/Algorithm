package git.Algorithm.programmers.lv3;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        Queue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        for(String operation : operations){
            String[] temp = operation.split(" ");
            int tmp = Integer.parseInt(temp[1]);
            if(temp[0].equals("I")){
                minQ.offer(tmp);
                maxQ.offer(tmp);
            }
            else if(!minQ.isEmpty()){
                if (tmp == 1) {
                    int max = maxQ.poll();
                    minQ.remove(max);
                }
                else{
                    int min = minQ.poll();
                    maxQ.remove(min);
                }
            }
        }

        if(!minQ.isEmpty()){
            answer[0] = maxQ.poll();
            answer[1] = minQ.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] a = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        new DoublePriorityQueue().solution(a);
    }
}
