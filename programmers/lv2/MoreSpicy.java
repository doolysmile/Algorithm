package git.Algorithm.programmers.lv2;
import java.util.*;
public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int tmp1 = 0;
        int tmp2 = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville){
            pq.offer(i);
        }
        while(pq.size()>1 && pq.peek() < K){
            tmp1 = pq.poll();
            tmp2 = pq.poll();

            answer++;
            pq.offer(tmp1 + tmp2*2);

        }
        if(pq.peek() < K ){
            answer = -1;
        }
        return answer;
    }
}
