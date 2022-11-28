package git.Algorithm.programmers.lv3;

import java.util.Arrays;
import java.util.Comparator;

public class Solution42884 {
    public int solution(int[][] routes) {
        int answer = 0;
        int cameraLocation = Integer.MIN_VALUE;
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for(int i = 0; i < routes.length; i++){
            if(routes[i][0] > cameraLocation){
                cameraLocation = routes[i][1];
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution42884 s = new Solution42884();
        int[][] arr = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        System.out.println(s.solution(arr));
    }
}
