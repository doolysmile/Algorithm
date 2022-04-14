package git.Algorithm.programmers.lv1;

import java.util.Arrays;

public class NotCompletion {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0 ; i < completion.length; i++){
            if (!completion[i].equals(participant[i])){
                answer = participant[i];
                return answer;
            }
            answer = participant[i+1];
        }
        return answer;
    }

}
