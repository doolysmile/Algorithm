package git.Algorithm.programmers.lv2;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Solution42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        Queue<Integer> q = new LinkedList<>();
        int index = 0;
        int currentWeight = 0;
        while(index < truck_weights.length){
            if(answer > bridge_length){
                currentWeight -= q.poll();
            }
            if(currentWeight + truck_weights[index] <= weight){
                currentWeight += truck_weights[index];
                q.add(truck_weights[index]);
                index++;
            }
            else{
                q.add(0);
            }
            answer++;
        }
        answer = answer + bridge_length - 1;
        return answer;
    }

    public static void main(String[] args) {
        Solution42583 s = new Solution42583();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(s.solution(bridge_length, weight, truck_weights));
    }
}
