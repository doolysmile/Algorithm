package git.Algorithm.programmers.lv2;

public class CompressString {

    public int solution(String s) {
        int answer = s.length();
        for(int i = 1; i <= s.length()/2; i++){
            String cmp = s.substring(0,i);
            int ans_tmp = i;
            int samecount = 1;
            for(int j = i; j< s.length(); j = j+i){
                int end = j + i;
                if(j + i > s.length()){
                    end = s.length();
                }
                if(cmp.equals(s.substring(j, end))){
                    samecount++;
                }
                else{
                    cmp = s.substring(j, end);
                    ans_tmp = ans_tmp + cmp.length();
                    if(samecount > 1){
                        ans_tmp = ans_tmp + Integer.toString(samecount).length();
                    }
                    samecount = 1;
                }
            }
            if(samecount > 1){
                ans_tmp = ans_tmp + Integer.toString(samecount).length();
            }
            answer = Math.min(ans_tmp, answer);
        }
        return answer;
    }
    
}
