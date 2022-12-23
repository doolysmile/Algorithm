package git.Algorithm.programmers.lv2;

public class Solution70129 {
    public int[] solution(String s) {
        int[] answer = new int[2];
        StringBuilder sb = new StringBuilder(s);
        int cycle = 0;
        int cnt0 = 0;
        while (sb.length() > 1){
            StringBuilder tmp = new StringBuilder();
            for(int i = 0; i < sb.length(); i++){
                char c = sb.charAt(i);
                if(c == '0'){
                    cnt0++;
                }
                else{
                    tmp.append(c);
                }
            }
            sb = new StringBuilder(Integer.toBinaryString(tmp.length()));
            cycle++;
        }
        answer[0] = cycle;
        answer[1] = cnt0;
        return answer;
    }
}
