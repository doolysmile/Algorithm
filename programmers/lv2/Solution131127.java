package git.Algorithm.programmers.lv2;

import java.util.HashMap;
import java.util.Map;


public class Solution131127 {
    static Map<String, Integer> map;
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int[] check = new int[want.length];
        map = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]);
        }
        for(int i = 0; i < 10; i++) {
            if (map.containsKey(discount[i])) {
                map.put(discount[i], map.get(discount[i]) - 1);
            }
        }
        if(check()){
            answer++;
        }
        for(int i = 10; i < discount.length; i++){
            if(map.containsKey(discount[i])){
                System.out.println(discount[i]);
                map.put(discount[i], map.get(discount[i]) - 1);
            }
            if(map.containsKey(discount[i - 10])){
                map.put(discount[i - 10], map.get(discount[i - 10]) + 1);
            }
            if(check()){
                answer++;
            }
        }
        return answer;
    }
    public boolean check(){
        for(Integer value : map.values()){
            if(value > 0){
                return false;
            }
        }
        return true;
    }
/*
["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"]
 */
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3,2,2,2,1};
        String[] dis = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        Solution131127 s = new Solution131127();
        System.out.println(s.solution(want, number, dis));
    }
}
