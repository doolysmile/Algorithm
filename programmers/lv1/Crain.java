package git.Algorithm.programmers.lv1;

import java.util.*;

public class Crain {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i : moves) {
            for(int j = 0; j < board.length; j++) {
                if(board[j][i - 1] != 0) {
                    if(stack.size() != 0 && board[j][i - 1] == stack.peek()) {
                        stack.pop();
                        answer = answer + 2;
                    }
                    else {
                        stack.push(board[j][i - 1]);
                    }
                    board[j][i - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
