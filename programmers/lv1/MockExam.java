package git.Algorithm.programmers.lv1;

import java.util.*;

public class MockExam {

    public int[] solution(int[] answers) {

        int[] a = {1,2,3,4,5};
        int checkA = 0;
        int[] b = {2,1,2,3,2,4,2,5};
        int checkB = 0;
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        int checkC = 0;
        int max;
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < answers.length; i++){
            if(answers[i] == a[i%5]){
                checkA++;
            }
            if(answers[i] == b[i%8]){
                checkB++;
            }
            if(answers[i] == c[i%10]){
                checkC++;
            }
        }
        max = Math.max(checkA, Math.max(checkB, checkC));
        if(checkA == max)
            ans.add(1);
        if(checkB == max)
            ans.add(2);
        if(checkC == max)
            ans.add(3);
        int[] answer = new int[ans.size()];
        for(int i : ans){
            answer[j++] = i;
        }
        return answer;
    }
}
