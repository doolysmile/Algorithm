package git.Algorithm.programmers.lv1;

import java.util.Arrays;

public class KNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int j = 0;
        for (int[] i : commands){
            int[] buf = Arrays.copyOfRange(array, i[0] - 1, i[1]);
            Arrays.sort(buf);
            answer[j] = buf[i[2] - 1];
            j++;
        }

        return answer;
    }
}
