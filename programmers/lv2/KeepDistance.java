package git.Algorithm.programmers.lv2;
import java.util.*;
public class KeepDistance {
    public int[] solution(String[][] places) {

        int[] answer = new int[places.length];
        char[][] place = new char[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                place[j] = places[i][j].toCharArray();
            }
            answer[i] = check(place);
        }
        return answer;
    }

    public int check(char[][] place){
        int ans = 1;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(place[i][j] == 'P'){
                    if(bfs(place, i, j) == false){
                        return 0;
                    }
                }
            }
        }

        return ans;
    }
    public boolean bfs(char[][] place, int i, int j){

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j));
        int startX = 5;
        int startY = 5;

        while(!q.isEmpty()){

            Point tmp = q.poll();
            int x = tmp.x;
            int y = tmp.y;

            if((Math.abs(x - i) + Math.abs(j - y)) >= 2){
                break;
            }
            if(x + 1 < 5 && (startX != x+1 || startY != y)){
                if(place[x+1][y] == 'P'){
                    return false;
                }
                else if(place[x+1][y] == 'O'){
                    q.add(new Point(x+1, y));
                }
            }
            if(y + 1 < 5&& (startX != x || startY != y+1)){
                if(place[x][y + 1] == 'P'){
                    return false;
                }
                else if(place[x][y + 1] == 'O'){
                    q.add(new Point(x, y + 1));
                }
            }

            if(x - 1 >= 0&& (startX != x-1 || startY != y)){

                if(place[x-1][y] == 'P'){
                    return false;
                }
                else if(place[x-1][y] == 'O'){
                    q.add(new Point(x-1, y));
                }
            }
            if(y - 1 >= 0&& (startX != x || startY != y-1)){
                if(place[x][y-1] == 'P'){
                    return false;
                }
                else if(place[x][y-1] == 'O'){
                    q.add(new Point(x, y-1));
                }
            }
            startX = i;
            startY = j;
        }



        return true;
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
