package git.Algorithm.programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;

public class Solution42746 {
    public String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] nums = Arrays.stream(numbers).mapToObj(String::valueOf).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        }).toArray(String[]::new);

        for(int i = 0 ; i < nums.length; i++){
            if(i == 0 && nums[i].charAt(0) == '0'){
                sb.append(0);
                break;
            }
            sb.append(nums[i]);
        }
        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        Solution42746 s = new Solution42746();
        System.out.println("s.solution(new int[]{6, 10, 2}) = " + s.solution(new int[]{70,0,0,0,0}));
        s.solution(new int[]{6, 10, 2});
    }
}
