package git.Algorithm.programmers.lv3;
import java.util.*;
public class IntegerTriangle {
//    public int solution(int[][] triangle) {
//        int answer = 0;
//        int last = triangle.length -1;
//        for(int i = 1; i < triangle.length;i++){
//            for(int j = 0; j < triangle[i].length; j++){
//                int min = Math.max(j-1, 0);
//                int max = Math.min(j, triangle[i-1].length - 1);
//                triangle[i][j] += Math.max(triangle[i-1][min], triangle[i-1][max]);
//            }
//        }
//        Arrays.sort(triangle[last]);
//        answer = triangle[last][triangle[last].length - 1];
//        return answer;
//    }
/*
00
10 11
20 21 22

 */
    public int solution(int[][] triangle) {
        int answer = 0;
        for(int i =1; i < triangle.length; i++){
            triangle[i][0] += triangle[i - 1][0];
            triangle[i][i] += triangle[i - 1][i - 1];
            for(int j = 1; j < triangle[i].length; j++){
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
            }
        }

        return Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
    }
}
