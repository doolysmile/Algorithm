package git.Algorithm.programmers.lv2;

import java.util.ArrayList;

public class Solution17684 {
    public int[] solution(String msg) {
        int[] answer = {};
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 65; i <= 90; i++){
            list.add(String.valueOf((char)i));
        }
        String[] str = msg.split("");
        int save = 0;
        while(index < str.length){
            sb.append(str[index]);
            if(list.indexOf(sb.toString()) != -1){
                save = list.indexOf(sb.toString()) + 1;
                index++;
            }
            else {
                list.add(sb.toString());
                ans.add(save);
                sb = new StringBuilder();
            }
            if(index == str.length){
                ans.add(list.indexOf(sb.toString()) + 1);
            }
        }
        answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution17684 s = new Solution17684();
        System.out.println(s.solution("TOBEORNOTTOBEORTOBEORNOT"));
    }
}
