package git.Algorithm.programmers.lv1;

public class NegativePositivePlus {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < absolutes.length; i++){
            if(signs[i] == false){
                absolutes[i] = absolutes[i]*-1;
            }
            answer += absolutes[i];
        }
        return answer;
    }
}
