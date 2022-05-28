package git.Algorithm.programmers.lv3;
import java.util.*;
public class IntegerTriangle {
    public int solution(int[][] triangle) {
        int answer = 0;
        int last = triangle.length -1;
        for(int i = 1; i < triangle.length;i++){
            for(int j = 0; j < triangle[i].length; j++){
                int min = Math.max(j-1, 0);
                int max = Math.min(j, triangle[i-1].length - 1);
                triangle[i][j] += Math.max(triangle[i-1][min], triangle[i-1][max]);
            }
        }
        Arrays.sort(triangle[last]);
        answer = triangle[last][triangle[last].length - 1];
        return answer;
    }

}
