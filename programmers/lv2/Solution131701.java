package git.Algorithm.programmers.lv2;

import java.util.HashSet;
import java.util.Set;

public class Solution131701 {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= elements.length; i++){
            for(int j = 0; j < elements.length; j++){
                int temp = 0;
                for(int k = 0; k < i; k++){
                    temp += elements[(j + k) % elements.length];
                }
                set.add(temp);
            }
        }
        answer = set.size();
        return answer;
    }

}
