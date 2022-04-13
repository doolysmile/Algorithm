package git.Algorithm.programmers.lv2;

import java.util.*;

public class KakaoColoringBook {

    // 인자로 받는 2차원 배열 picture가 수정되면 답이 틀려서 추가한 부분
    int[][] board;

    public int[] solution(int m, int n, int[][] picture) {

        // 인자로 받는 2차원 배열 picture가 수정되면 답이 틀려서 추가한 부분
        board = new int[m][n];
        for(int i =0;i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = picture[i][j];
            }
        }

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ; j++){
                if(board[i][j] != 0){
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, board[i][j] ,board, m, n));
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int bfs(int i, int j, int color, int[][] pic, int m, int n) {
        int ans = 0;
        Queue<Point> queue = new LinkedList<>();
        pic[i][j] = 0;
        Point start = new Point(i,j);
        ans++;
        queue.offer(start);
        while(!queue.isEmpty()){
            Point tmp = queue.poll();
            int x = tmp.x;
            int y = tmp.y;
            if(x - 1 >= 0 && color == pic[x - 1][y]){
                pic[x - 1][y] = 0;
                queue.offer(new Point(x - 1, y));
                ans++;
            }
            if(x + 1 < m && color == pic[x + 1][y]){
                pic[x + 1][y] = 0;
                queue.offer(new Point(x + 1, y));
                ans++;
            }
            if(y - 1 >= 0 && color == pic[x][y - 1]){
                pic[x][y - 1] = 0;
                queue.offer(new Point(x, y - 1));
                ans++;
            }
            if(y + 1 < n && color == pic[x][y + 1]){
                pic[x][y + 1] = 0;
                queue.offer(new Point(x, y +1));
                ans++;
            }
        }
        return ans;
    }
}
