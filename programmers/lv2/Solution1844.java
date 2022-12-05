package git.Algorithm.programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1844 {
    public int solution(int[][] maps) {
        int answer = 0;
        int height = maps.length;
        int width = maps[0].length;
        int[][] visited = new int[height][width];
        Queue<Node> q = new LinkedList<>();
        int[] moveX = {1, 0, -1, 0};
        int[] moveY = {0, 1, 0, -1};
        q.add(new Node(0,0));
        visited[0][0] = 1;
        while(!q.isEmpty()){
            Node currentNode = q.poll();
            int currentX = currentNode.x;
            int currentY = currentNode.y;
            for(int i = 0; i < 4; i++){
                int x = currentX + moveX[i];
                int y = currentY + moveY[i];
                if( 0 <= x && x < height && 0 <= y && y < width && maps[x][y] == 1 && visited[x][y] == 0){
                    visited[x][y] = visited[currentX][currentY] + 1;
                    q.add(new Node(x,y));
                }
            }
            if(visited[height - 1][width - 1] != 0){
                break;
            }
        }
        answer = visited[height - 1][width - 1] == 0 ? -1 : visited[height - 1][width - 1];
        return answer;
    }
    class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Solution1844 s = new Solution1844();
        int[][] a = {	{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        s.solution(a);
    }
}
