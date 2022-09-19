package git.Algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2580 {
    static int[][] map;
    static ArrayList<Node> zero;
    static StringBuilder sb;
    static boolean end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        map = new int[9][9];
        zero = new ArrayList<>();
        end = false;
        for(int i = 0; i < 9 ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    zero.add(new Node(i, j, 0));
                }
            }
        }
        dfs(0, 0);

    }
    static void dfs(int depth, int start){

        if(depth == zero.size()){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    sb.append(map[i][j]);
                    if(j != 8){
                        sb.append(" ");
                    }
                }
                if (i != 8) {
                    sb.append("\n");
                }
            }
            System.out.print(sb.toString());
            end = true;
            return;
        }
        for(int i = start ; i < zero.size(); i++){
            Node temp = zero.get(i);
            if(temp.value == 0){
                for(int j = 1; j <= 9; j++){
                    if(check(i, j)){
                        map[temp.x][temp.y] = j;
                        dfs(depth + 1, i + 1);
                        if(end){
                            return;
                        }
                        map[temp.x][temp.y] = 0;
                    }
                }
                if(map[temp.x][temp.y] == 0){
                    break;
                }
            }

        }
    }
    static boolean check(int zeroIndex, int num){
        Node temp = zero.get(zeroIndex);
        int x = temp.x / 3;
        int y = temp.y / 3;
        for(int i = 0; i < 9; i++){
            if(map[i][temp.y] == num){
                return false;
            }
        }
        for(int j = 0; j < 9; j++){
            if(map[temp.x][j] == num){
                return false;
            }
        }
        for(int i = x*3; i < x*3 + 3; i++){
            for(int j = y*3; j < y*3 + 3; j++){
                if(map[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
    static class Node {
        int x;
        int y;
        int value;
        Node(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
