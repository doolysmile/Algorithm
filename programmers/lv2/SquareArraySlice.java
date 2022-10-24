package git.Algorithm.programmers.lv2;

import java.util.Arrays;

public class SquareArraySlice {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];
        long leftX = left / n;
        long leftY = left % n;
        int index = 0;
        while(index < answer.length){
            answer[index] = (int)Math.max(leftX, leftY) + 1;
            leftY++;
            if(leftY == n){
                leftX++;
                leftY = 0;
            }
            index++;
        }
        return answer;
    }
}
